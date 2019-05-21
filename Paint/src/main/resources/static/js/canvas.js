window.onload = function () {
    var url = window.location.href;
    var i = url.indexOf("?");
    //根据url获取当前打开的图画文件名
    if(i!==null && i!==undefined && i !== -1) {
        currentFileName = url.substring(i+1, url.length);
        // console.log(currentFileName);
        $.ajax({
            type: "POST",
            url: "/paintFile/getPaintFile",
            data: {
                fileName : currentFileName
            },
            success:function (result) {
                currentTrackList = result.trackList;
                currentFrameList = result.frameList;
                restoreMark();
            }
        });
    }else
        currentFileName = null;
}

//按下作图按钮触发的函数
function paintButtonClicked() {
    //当开关为开启状态时 按下开关 取消作图
    if(paintButtonFlag){
        stopAll();
        paintButtonFlag = false;
    }
    else{
        startPaint();
        paintButtonFlag = true;
    }
}

//开始作图
function startPaint() {
    stopAll();
    canvas.onmousedown = startPainting;
    canvas.onmousemove = paint;
    canvas.onmouseup = stopPainting;
    canvas.onmouseout = stopPainting;
    //根据情况更改作图按钮内的字样、颜色
    var paintButton = document.getElementById("paintButton");
    paintButton.style.color = "yellow";
    paintButton.innerText = "正在作图";
}

//按下标注按钮的函数
function markButtonClicked() {
    //当开关为开启状态时 按下开关 取消标注
    if(markButtonFlag){
        stopAll();
        markButtonFlag = false;
    }
    else{
        startMark();
        markButtonFlag = true;
    }
}

//开始标注
function startMark() {
    stopAll();
    canvas.onmousedown = startMarking;
    canvas.onmousemove = mark;
    canvas.onmouseup = stopMarking;
    canvas.onmouseout = cancelMarking;
    //更改标注按钮内的字样、颜色
    var markButton = document.getElementById("markButton");
    markButton.style.color = "yellow";
    markButton.innerText = "正在标注";
}

//停止对canvas的一切动作
function stopAll() {
    canvas.onmousedown = null;
    canvas.onmousemove = null;
    canvas.onmouseup = null;
    canvas.onmouseout = null;

    //还原按钮内的字样、颜色
    var paintButton = document.getElementById("paintButton");
    paintButton.style.color = "white";
    paintButton.innerText = "使用画笔";

    var markButton = document.getElementById("markButton");
    markButton.style.color = "white";
    markButton.innerText = "开始标注";
    paintButtonFlag  = false;
    markButtonFlag = false;
}

//保存当前图画
function saveAll() {
    var savePermitted = false;
    var inputFileName;
    if(currentFileName === null){
        inputFileName = window.prompt("请在此输入文件名：(文件名中请不要包含中文、特殊字符)","");
    }else{
        inputFileName = window.prompt("请在此输入文件名：(文件名中请不要包含中文、特殊字符)",currentFileName);
    }

    //过滤掉输入的空格;
    inputFileName = inputFileName.replace(/(^\s*)|(\s*$)/g, '');

    if (inputFileName === '' || inputFileName === undefined || inputFileName === null) {
        alert("请输入英文或数字！");
    }else {
        $.ajax({
            type: "POST",
            url: "/paintFile/isPaintFileNameExist",
            data: {
                fileName : inputFileName
            },
            success:function (result) {
                if(result === true){
                    savePermitted = window.confirm("你输入的文件名与旧的文件名重复，是否覆盖旧的文件？");
                    if(savePermitted)
                        currentFileName = inputFileName;
                }
                else{
                    currentFileName = inputFileName;
                    savePermitted = true;
                }

                if(savePermitted){
                    var paintFile = new PaintFile(currentFileName, currentTrackList, currentFrameList);
                    var paintFileString = JSON.stringify(paintFile);
                    $.ajax({
                        type: "POST",
                        url: "/paintFile/savePaintFile",
                        data: {
                            paintFileString : paintFileString
                        },
                        success:function (result) {
                            if(result === true)
                                alert("保存成功");
                            else
                                alert("保存失败");
                        }
                    });
                }

            }
        });
    }
}

//回到首页
function jumpToHome(){
    window.location.href = "index.html";
}

