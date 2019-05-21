package com.demo.paint.controller;

import com.demo.paint.businesslogic.recogniseBL.RecogniseBLImpl;
import com.demo.paint.businesslogic.recogniseBL.RecogniseBLService;
import com.demo.paint.entity.Paint;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecogniseController {

    private RecogniseBLService recogniseBLService;

    public RecogniseController(){
        recogniseBLService = new RecogniseBLImpl();
    }

    @RequestMapping(value = "/recognise/recognisePaint", method = RequestMethod.POST)
    public String recognisePaint(String paintString){
        Gson gson = new GsonBuilder().create();
        Paint paint = gson.fromJson(paintString, Paint.class);
        return recogniseBLService.recogniseShapeOfPaint(paint);
    }


}
