package com.demo.paint.entity;

import java.util.Collections;
import java.util.List;

public class Track {
    //落点的数组
    private List<Point> pointList;

    public List<Point> getPointList() {
        return pointList;
    }

    public Point getStartPoint(){
        return pointList.get(0);
    }

    public Point getEndPoint(){
        return pointList.get(pointList.size()-1);
    }

    public void reversePointList(){
        Collections.reverse(pointList);
    }

    public Track(List<Point> pointList){
        this.pointList = pointList;
    }
}
