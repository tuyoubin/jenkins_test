package com.demo.paint.data.dataImpl;

import com.demo.paint.data.dataService.PaintFileDataService;
import com.demo.paint.entity.PaintFile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class PaintFileDataImpl implements PaintFileDataService {

    @Override
    public boolean savePaintFile(PaintFile paintFile) {
        String fileName = paintFile.getFileName();
        Gson gson = new GsonBuilder().create();
        String content = gson.toJson(paintFile);
//        List<Track> trackList = paintFile.getTrackList();
//        List<Frame> frameList = paintFile.getFrameList();

        String filePath = getFilePath(fileName);
        File file = new File(filePath);

        //若文件不存在，则创建文件
        if(!file.exists()){
            try {
                if(!file.createNewFile())
                    return false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(content);

            bufferedWriter.close();
            fileWriter.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public PaintFile getPaintFile(String fileName) {
        String filePath = getFilePath(fileName);
        File file = new File(filePath);

        //若文件不存在，则创建文件
        if(!file.exists()){
            return null;
        }else{
            Gson gson = new GsonBuilder().create();
            String result = "";
            try{
                FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                result = bufferedReader.readLine();

                bufferedReader.close();
                fileReader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            return gson.fromJson(result, PaintFile.class);
        }
    }

    @Override
    public List<String> getPaintFileNameList() {
        String dirPath = "./PaintData";
        ArrayList<String> ret = new ArrayList<>();
        File dirFile = new File(dirPath);
        File[] files = dirFile.listFiles();
        String filePath;
        int index;
        for(File file : files){
            if(file.isFile()){
                filePath = file.toString();
                index = filePath.lastIndexOf("\\");
                //去除.txt后缀
                ret.add(filePath.substring(index+1, filePath.length()-4));
            }

        }
        return ret;
    }

    @Override
    public boolean isPaintFileNameExist(String fileName) {
        List<String> fileNameList =  getPaintFileNameList();
        for(String name : fileNameList){
            if(fileName.equals(name))
                return true;
        }
        return false;
    }


    //获取真正的文件路径
    private String getFilePath(String fileName){
        //fileName是不包含.txt后缀的
        return "./PaintData" + "/" + fileName +".txt";
    }
}
