package com.demo.paint.businesslogic.recogniseBL;

import com.demo.paint.entity.Paint;

public interface RecogniseBLService {
    /**
     * 根据图画 判断形状
     * @param paint
     * @return
     */
    String recogniseShapeOfPaint(Paint paint);
}
