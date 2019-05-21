window.onload = function () {
    //页面加载时 向后台发送获取文件名列表的请求
    $.ajax({
        type: "POST",
        url: "/paintFile/getPaintFileNameList",
        data: {},
        success:function (result) {
            var fileList = document.getElementById("fileList");
            var fileRow;
            var fileItemReference;
            var pageUrl;
            var fileNameList = result;
            console.log(result);
            for(var i = 0; i < fileNameList.length; i++){
                pageUrl = "paint.html?" + fileNameList[i];
                fileRow = document.createElement("li");
                fileRow.className = "fileRow";

                fileItemReference = document.createElement("a");
                fileItemReference.innerHTML = "<span class=\"fileNameText\">" + fileNameList[i] + "</span>";
                fileItemReference.href = pageUrl;

                fileRow.appendChild(fileItemReference);
                fileList.appendChild(fileRow);
            }

            //若此时文件列表为空，则隐藏提示语
            if(fileNameList.length !== 0){
                var remind = document.getElementById("remind");
                remind.style.display = "none";
            }
        }
    });
}

//跳转至作图页面
function jumpToPaint() {
    window.location.href = "paint.html";
}
