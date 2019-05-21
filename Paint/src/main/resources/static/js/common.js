// 获取 canvas 对象
var canvas = document.getElementById('canvas');
// 获取绘图环境
var context = canvas.getContext('2d');

//临时的绘图印象
var tempImageData;

//判断作图开关状态，初始为关闭状态（不允许作图）
var paintButtonFlag = false;
//判断标注开关状态，初始为关闭状态（不允许作图）
var markButtonFlag = false;

//判断是否正在作画
var isPainting = false;
//判断是否正在标注
var isMarking = false;


//当前笔画开始点坐标
var currentStartX;
var currentStartY;
//当前笔画结束点的坐标
var currentEndX;
var currentEndY;

//当前落点的数组
var currentPointList = [];
//当前轨迹的数组
var currentTrackList = [];

//当前标注框选的矩形
var currentFrame = null;
//当前矩形的数组
var currentFrameList = [];

//当前文件名
var currentFileName = null;

//定义落点的类
function Point(x,y){
    this.x = x;
    this.y = y;
}

//定义轨迹的类
function Track(pointList) {
    this.pointList = pointList;
}

//定义矩形标注的类
function Frame(startX, startY, width, height, label, shape) {
    this.startX = startX;
    this.startY = startY;
    this.width = width;
    this.height = height;
    this.label = label;
    this.shape = shape;
}

//定义图画类
function Paint(trackList){
    this.trackList = trackList;
}

// function Label(frameList) {
//     this.frameList = frameList;
// }

//定义图画文件类
function PaintFile (fileName, trackList, frameList){
    this.fileName = fileName;
    this.trackList = trackList;
    this.frameList = frameList;
}
