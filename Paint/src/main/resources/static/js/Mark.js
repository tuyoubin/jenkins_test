//当前矩形左上角顶点X坐标
var topLeftX;
//当前矩形左上角顶点Y坐标
var topLeftY;
//当前矩形宽度
var currentWidth;
//当前矩形长度
var currentLength;
//矩形框计数器
var frameCounter = 0;

//开始标注
function  startMarking(e){
    isMarking = true;
    currentStartX = e.offsetX;
    currentStartY = e.offsetY;
    tempImageData = context.getImageData(0, 0, canvas.width, canvas.height);
}

//标注
function  mark(e) {
    if(isMarking){
        context.putImageData(tempImageData, 0, 0);
        currentEndX = e.offsetX;
        currentEndY = e.offsetY;

        topLeftX = (currentEndX < currentStartX)? currentEndX: currentStartX;
        topLeftY = (currentEndY < currentStartY)? currentEndY: currentStartY;
        currentWidth = Math.abs(currentEndX - currentStartX);
        currentLength = Math.abs(currentEndY - currentStartY);

        currentFrame = new Frame(topLeftX, topLeftY, currentWidth, currentLength, "", null);
        context.strokeRect(topLeftX, topLeftY, currentWidth, currentLength);

    }
}

//停止标注
function  stopMarking() {
    if(isMarking) {
        if(currentWidth > -1){
            frameCounter++;
            currentFrameList.push(currentFrame);
            console.log(currentFrameList);
            console.log(currentFrame);
            // var paintString = JSON.stringify(new Paint(currentTrackList));

            var paintString = JSON.stringify(new Paint( getTrackListInTheFrame(topLeftX, topLeftY, currentWidth, currentLength)));
            //console.log(paintString);
            $.ajax({
                type: "POST",
                url: "/recognise/recognisePaint",
                data: {
                    paintString: paintString
                },
                success: function (result) {
                    var shape = result;
                    currentFrame.shape = shape;

                    AddShapeTag(shape, currentFrame.startX + currentFrame.width/2, currentFrame.startY + currentFrame.height/2);
                    AddLabelTag(frameCounter+". ", currentFrame.startX, currentFrame.startY);
                    AddOption(frameCounter);
                    console.log(currentFrameList);
                }
            });

        }

        tempImageData = context.getImageData(0, 0, canvas.width, canvas.height);
        isMarking = false;
        currentWidth = -1;
    }
}

//一旦鼠标移出画布，就取消正在框选的矩形
function  cancelMarking() {
    isMarking = false;
    restoreMark();
    tempImageData = context.getImageData(0, 0, canvas.width, canvas.height);
}

//添加标注内容
function  addLabel() {
    var frameIdSelector = document.getElementById("frameIdSelector");
    var index = frameIdSelector.selectedIndex;//获取当前选择项的索引.
    if(index < 0)
        alert("你还未框选任何矩形区域！");
    else{
        var inputLabel = document.getElementById("inputLabel");
        var text = inputLabel.value;
        //过滤掉输入的空格;
        var str = text.replace(/(^\s*)|(\s*$)/g, '');
        if (str === '' || str === undefined || str === null) {
            alert("请输入文字！");
        }else{
            ModifyLabelTag(index, str);
            currentFrame = currentFrameList[index];
            currentFrame.label = str;
        }
    }
}

//当下拉框内选中了矩形Id后，将输入栏中标注内容与矩形绑定
function selectFrameId() {
    var frameIdSelector = document.getElementById("frameIdSelector");
    var index = frameIdSelector.selectedIndex;
    var inputLabel = document.getElementById("inputLabel");
    if(index >= 0)
        inputLabel.value = currentFrameList[index].label;
}

//为右侧栏 标注下拉框添加元素
function  AddOption(index) {
    //为右侧矩形编号选择器（下拉框） 添加元素
    var frameIdSelector = document.getElementById("frameIdSelector");
    var option = document.createElement("option");
    option.innerText = index+"";
    option.value = index+"";
    frameIdSelector.appendChild(option);
}

//修改画布上标注内容
function  ModifyLabelTag(index, label) {
    var labelDiv = document.getElementById("labelTagsOnCanvas");
    var childs = labelDiv.childNodes;
        childs[index].innerText = (index+1) + ". " + label;
}

//添加形状标签
function AddShapeTag(shape, startX, startY) {
    var tagDiv = document.getElementById("shapeTagsOnCanvas");
    var tag = document.createElement('p');
    tag.innerText = shape;
    tag.className = "shapeTagsOnCanvas";
    tag.style.left = startX+"px";
    tag.style.top = startY+"px";
    tagDiv.appendChild(tag);
}

//添加标注标签
function AddLabelTag(label, startX, startY) {
    var tagDiv = document.getElementById("labelTagsOnCanvas");
    var tag = document.createElement('p');
    tag.innerText = label;
    tag.className = "labelTagsOnCanvas";
    tag.style.left = startX+"px";
    tag.style.top = startY+"px";
    tagDiv.appendChild(tag);
}

//清空所有标注信息
function clearMark() {
    context.clearRect(0,0,canvas.width,canvas.height);
    restorePaint();

    //清除已有的标签
    clearTag();
    //清除已有的标注数组
    currentFrameList = [];
    //清除计数器
    frameCounter = 0;
    startMark();
}

//清空标注标签、形状标签
function clearTag() {
    var TagsDiv = document.getElementById("shapeTagsOnCanvas");
    var childs = TagsDiv.childNodes;
    for(var i = childs.length - 1; i >= 0; i--) {
        TagsDiv.removeChild(childs[i]);
    }

    TagsDiv = document.getElementById("labelTagsOnCanvas");
    childs = TagsDiv.childNodes;
    for(i = childs.length - 1; i >= 0; i--) {
        TagsDiv.removeChild(childs[i]);
    }

    var frameIdSelector = document.getElementById("frameIdSelector");
    childs = frameIdSelector.childNodes;
    for(i = childs.length - 1; i >= 0; i--) {
        frameIdSelector.removeChild(childs[i]);
    }
}


//根据currentFrameList里的内容 恢复标注记录
function restoreMark() {
    //console.log(currentFrameList);
    clearTag();
    context.clearRect(0,0,canvas.width,canvas.height);
    restorePaint();

    for(var i = 0; i < currentFrameList.length; i++){
        currentFrame = currentFrameList[i];
        context.strokeRect(currentFrame.startX, currentFrame.startY, currentFrame.width, currentFrame.height);
        AddShapeTag(currentFrame.shape, currentFrame.startX + currentFrame.width/2, currentFrame.startY + currentFrame.height/2);
        AddLabelTag((i+1)+". "+currentFrame.label, currentFrame.startX, currentFrame.startY);
        AddOption(i+1);
    }

    frameCounter = currentFrameList.length;
}