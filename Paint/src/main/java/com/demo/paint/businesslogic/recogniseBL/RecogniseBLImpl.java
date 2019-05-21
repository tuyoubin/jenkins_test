package com.demo.paint.businesslogic.recogniseBL;

import com.demo.paint.entity.Paint;
import com.demo.paint.entity.Track;

import java.util.List;

public class RecogniseBLImpl implements RecogniseBLService {

    private SizeCounter sizeCounter;

    public RecogniseBLImpl(){
        sizeCounter = new SizeCounter();
    }

    @Override
    public String recogniseShapeOfPaint(Paint paint) {
        List<Track> trackList = paint.getTrackList();
        int numberOfSize = sizeCounter.countNumberOfSize(trackList);
        String shape;
        if(numberOfSize < 2)
            shape = "null";
        else if(numberOfSize == 2)
            shape = "line";
        else if(numberOfSize == 3)
            shape = "triangle";
        else if(numberOfSize == 4)
            shape = "rectangle";
        else if(numberOfSize == 5 || numberOfSize == 6)
            shape = "polygon";
        else
            shape = "circle";

        return shape;
    }
}
