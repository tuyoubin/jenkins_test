package com.demo.paint.entity;

import java.util.List;

public class PaintFile {
    private String fileName;
    private List<Track> trackList;
    private List<Frame> frameList;

    public String getFileName() {
        return fileName;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public List<Frame> getFrameList() {
        return frameList;
    }

    public PaintFile(String fileName, List<Track> trackList, List<Frame> frameList) {
        this.fileName = fileName;
        this.trackList = trackList;
        this.frameList = frameList;
    }
}
