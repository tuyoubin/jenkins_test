package com.demo.paint.businesslogic.recogniseBL;

import com.demo.paint.entity.Point;
import com.demo.paint.entity.Track;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SizeCounter {

    //用于判定用户作图中 两个点是否为不同点的临界距离标准
    //当两点间距小于limitedDistance时， 将这两个点视作一个点
    private final double limitedDistance = 20;

    //用于判定用户作图中 夹角是否为180°的余弦值的临界标准
    //当夹角余弦值小于limitedCosine时， 将该夹角视为180°
    private final double limitedCosine = -0.75;

    /**
     * 根据轨迹数组 判定图案（视作凸多边形）有多少条边
     * @param trackList 轨迹数组
     * @return 边数
     */
    public int countNumberOfSize(List<Track> trackList){

        if(trackList.size() == 0)
            return 0;

        //将每一条曲线内 可能成为凸型内角的顶点提取出来并重组为轨迹曲线
        List<Track> crossoverPointTrackList = new ArrayList<>();
        for(Track track: trackList)
            crossoverPointTrackList.add(getCrossoverPointTrack(track));

        Point p1;
        Point p2;

        List<Point> points = getSortedPointList(crossoverPointTrackList);
        List<Point> result = new ArrayList<>();
        result.add(points.get(0));
        p1 = points.get(0);

        // 下面根据点之间的距离排除掉部分可能无法作为内角顶点的点
        for(int i = 1; i < points.size(); i++){
            p2 = points.get(i);
            if(getDistance(p1, p2) > limitedDistance){
                result.add(p2);
                p1 = points.get(i);
            }
        }

        if(getDistance(result.get(0), result.get(result.size()-1)) < limitedDistance)
            result.remove(result.size()-1);

        System.out.println(result.size());
        return result.size();
    }

    private List<Point> getSortedPointList(List<Track> trackList){
        Point terminal;
        Point p1;
        Point p2;
        int index;
        double d1;
        double d2;
        double minDistance;
        boolean needReverse;

        Track tempTrack;

        // 下面将图形边界的笔画顺序按照某一方向（顺时针或逆时针），将轨迹落点顺序重新排列
        for(int i = 0; i < trackList.size()-1; i++){
            terminal = trackList.get(i).getEndPoint();
            index = i+1;
            minDistance = getDistance(terminal, trackList.get(i+1).getStartPoint());
            needReverse = false;
            for(int j = i+1; j < trackList.size(); j++){
                needReverse = false;
                p1 = trackList.get(j).getStartPoint();
                p2 = trackList.get(j).getEndPoint();
                d1 = getDistance(terminal, p1);
                d2 = getDistance(terminal, p2);
                if(d1<d2 && d1<minDistance) {
                    minDistance = d1;
                    index = j;
                }
                else if(d2<d1 && d2<minDistance){
                    minDistance = d2;
                    needReverse = true;
                    index = j;
                }
            }

            //交换第index项 与 第i+1项
            tempTrack = trackList.get(i+1);
            trackList.set(i+1, trackList.get(index));
            trackList.set(index, tempTrack);

            if(needReverse)
                trackList.get(i+1).reversePointList();
        }
        // 用points数组 存所有重组后的落点数组
        List<Point> points = new ArrayList<>();
        for(Track track : trackList)
            points.addAll(track.getPointList());
        return points;
    }

    //获取一段曲线上包含端点在内的所有可能的转折点（可能产生图形内角的点）构成的轨迹
    private Track getCrossoverPointTrack(Track track){
        List<Point> originalPointList = track.getPointList();

        if(originalPointList.size() < 3)
            return track;

        List<Point> result = new ArrayList<>();
        Point start = originalPointList.get(0);
        Point middle = originalPointList.get(1);
        Point end;
        Point temp;

        result.add(start);
        for(int i = 1; i < originalPointList.size()-1; i++){
            end = originalPointList.get(i+1);
            if(isCollinearApproximately(start,middle,end))
                middle = end;
            else{
                result.add(middle);
                temp = middle;
                middle = end;
                start = temp;
            }

            if(i == originalPointList.size()-2)
                result.add(end);
        }

        return new Track(result);
    }




    //判断曲线上相邻的三个点p1,p2,p3是否共线
    //通过p1 p2 p3形成的夹角是否接近180° 进行大致的判定
    private boolean isCollinearApproximately(Point p1, Point p2, Point p3){
        double cosine = getCosine(p2.getX()-p1.getX(), p2.getY()-p1.getY(),
                p2.getX()-p3.getX(), p2.getY()-p3.getY());
        if(cosine < limitedCosine)
            return true;
        return false;
    }

    //计算两个向量夹角的余弦值
    private double getCosine(int vector_x1, int vector_y1, int vector_x2, int vector_y2) {
        double len1 = Math.sqrt(Math.pow(vector_x1,2)+Math.pow(vector_y1,2));
        double len2 = Math.sqrt(Math.pow(vector_x2,2)+Math.pow(vector_y2,2));
        double product = vector_x1*vector_x2 + vector_y1*vector_y2;
        return product/(len1*len2);
    }

    //计算两个点的距离
    private double getDistance(Point p1, Point p2) {
        double squareX = Math.pow((p1.getX() - p2.getX()), 2);
        double squareY = Math.pow((p1.getY() - p2.getY()), 2);
        return Math.sqrt(squareX + squareY);
    }

}
