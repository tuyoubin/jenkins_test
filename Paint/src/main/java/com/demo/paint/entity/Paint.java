package com.demo.paint.entity;

import java.util.List;

public class Paint {
    //轨迹的数组
    private List<Track> trackList;

    public List<Track> getTrackList() {
        return trackList;
    }

    public Paint(List<Track> trackList) {
        this.trackList = trackList;
    }

}
