package com.demo.paint.controller;

import com.demo.paint.businesslogic.paintFileBL.PaintFileBLImpl;
import com.demo.paint.businesslogic.paintFileBL.PaintFileBLService;
import com.demo.paint.entity.PaintFile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaintFileController {

    private PaintFileBLService paintFileBLService;

    public PaintFileController(){
        paintFileBLService = new PaintFileBLImpl();
    }

    @RequestMapping(value = "/paintFile/savePaintFile", method = RequestMethod.POST)
    public boolean savePaintFile(String paintFileString){
//        System.out.println(paintFileString);
        Gson gson = new GsonBuilder().create();
        PaintFile paintFile = gson.fromJson(paintFileString, PaintFile.class);
        return paintFileBLService.savePaintFile(paintFile);
    }

    @RequestMapping(value = "/paintFile/getPaintFile", method = RequestMethod.POST)
    public PaintFile getPaintFile(String fileName){
        PaintFile p = paintFileBLService.getPaintFile(fileName);
        return p;
    }

    @RequestMapping(value = "/paintFile/getPaintFileNameList", method = RequestMethod.POST)
    public List<String> getPaintFileNameList() {
        return paintFileBLService.getPaintFileNameList();
    }

    @RequestMapping(value = "/paintFile/isPaintFileNameExist", method = RequestMethod.POST)
    public boolean isPaintFileNameExist(String fileName) {
        return paintFileBLService.isPaintFileNameExist(fileName);
    }
}
