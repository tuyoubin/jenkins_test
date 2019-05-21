//开始作图
function startPainting(e) {
    if(isPainting === false){
        isPainting = true;
        currentStartX = e.offsetX;
        currentStartY = e.offsetY;
        currentPointList.push(new Point(currentStartX, currentStartY));
    }
}

//作图
function paint(e){
    if(isPainting){
        //实现作图，即从上一落点到该落点连接一条线段
        context.beginPath();
        context.moveTo(currentStartX,currentStartY);
        context.lineTo(e.offsetX,e.offsetY);
        context.stroke();

        //将该落点保存到当前轨迹内
        currentPointList.push(new Point(e.offsetX,e.offsetY));

        // 当前落点将作为下一次 线段的 起始点。
        currentStartX = e.offsetX;
        currentStartY = e.offsetY;
    }
}

//停止作图
function stopPainting() {
    if (isPainting) {
        var currentTrack = getOptimizedTrack(currentPointList);
        //只有当前曲线内点数超过一个时,将曲线轨迹保存
        if (currentPointList.length > 1)
            currentTrackList.push(currentTrack);
    }
    isPainting = false;
    currentPointList = [];
}

//清空画布
function clearPaint() {
    clearMark();
    context.clearRect(0,0,canvas.width,canvas.height);
    //清除已有的轨迹信息
    currentPointList = [];
    currentTrackList = [];
    startPaint();
}

//获取位于框选的矩形内部的轨迹数组
function getTrackListInTheFrame(startX, startY, width, height){
    var resultTrackList = [];
    var resultPointList;
    var tempPointList;
    var tempPoint;
    for(var i = 0; i < currentTrackList.length; i++){
        resultPointList = [];
        tempPointList = currentTrackList[i].pointList;
        for(var j = 0; j < tempPointList.length; j++){
            tempPoint = tempPointList[j];
            if( tempPoint.x>startX && (tempPoint.x<startX+width)
            &&tempPoint.y>startY && (tempPoint.y<startY+height)){
                resultPointList.push(tempPoint);
            }
        }
        //当一条轨迹内 有至少两个点位于矩形内部时，将这些点记录下来
        if(resultPointList.length > 1)
            resultTrackList.push(new Track(resultPointList));
    }
    return resultTrackList;
}

//根据currentTrackList的内容恢复作画
function restorePaint() {
    var tempPointList;
    var tempX;
    var tempY;
    //console.log(currentTrackList);
    for(var i = 0; i < currentTrackList.length; i++){
        tempPointList = currentTrackList[i].pointList;
        //console.log(tempPointList);
        tempX = tempPointList[0].x;
        tempY = tempPointList[0].y;
        for(var j = 1; j < tempPointList.length; j++){
            context.beginPath();
            context.moveTo(tempX,tempY);
            context.lineTo(tempPointList[j].x, tempPointList[j].y);
            context.stroke();
            tempX = tempPointList[j].x;
            tempY = tempPointList[j].y;
        }
    }
}

//根据落点数组 获取简化后的落点轨迹
function getOptimizedTrack(pointList){
    if(pointList.length < 3)
        return new Track(pointList);
    else{
        // 当点数足够多时，试图简化落点数组
        // 即对曲线中存在的连续三点满足 中间点位于两端点所连成的线段内时 将中间的点从数组内删去
        var resultPointList = [];

        var start = pointList[0];
        var middle = pointList[1];
        var end;
        var temp;
        var flag;

        resultPointList.push(start);
        for(var i = 1; i < pointList.length-1; i++){
            end = pointList[i+1];
            flag = getPosition(start, middle, end);

            if(flag === 1){
                    middle = end;
            }else{
                resultPointList.push(middle);
                temp = middle;
                middle = end;
                start = temp;
            }

            if(i === pointList.length-2)
                resultPointList.push(end);
        }

        return new Track(resultPointList);
    }
}


// 判断三点的位置关系
// 若三点共线，且p2落于线段p1 p3上（包含端点位置），则返回 1
// 若三点共线，且p2并不落于线段p1 p3上，则返回 -1
// 若三点不共线，则返回0
function getPosition(p1, p2, p3) {
    if((p1.x-p2.x) * (p1.y-p3.y)
        === (p1.y-p2.y) * (p1.x-p3.x)) {
        //console.log("Bingo");
        // 若p2与p1、p3中的一点重合
        if( (p2.x === p1.x && p2.y === p1.y) || (p2.x === p3.x && p2.y === p3.y))
            return 1;
        // 若p2落在线段p1 p3内部
        if( (p2.x-p1.x) * (p2.x-p3.x) < 0
            ||(p2.y-p1.y) * (p2.y-p3.y) < 0 )
            return 1;

        return -1;
    }
    return 0;
}
