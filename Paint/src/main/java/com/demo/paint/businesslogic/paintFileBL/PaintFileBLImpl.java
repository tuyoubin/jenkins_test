package com.demo.paint.businesslogic.paintFileBL;

import com.demo.paint.data.dataImpl.PaintFileDataImpl;
import com.demo.paint.data.dataService.PaintFileDataService;
import com.demo.paint.entity.PaintFile;

import java.util.List;

public class PaintFileBLImpl implements PaintFileBLService{

    private PaintFileDataService paintFileDataService;

    public PaintFileBLImpl(){
        paintFileDataService = new PaintFileDataImpl();
    }

    @Override
    public boolean savePaintFile(PaintFile paintFile) {
        return paintFileDataService.savePaintFile(paintFile);
    }

    @Override
    public PaintFile getPaintFile(String fileName) {
        return paintFileDataService.getPaintFile(fileName);
    }

    @Override
    public List<String> getPaintFileNameList() {
        return paintFileDataService.getPaintFileNameList();
    }

    @Override
    public boolean isPaintFileNameExist(String fileName) {
        return paintFileDataService.isPaintFileNameExist(fileName);
    }
}
