package com.demo.paint.data.fileHelper;

import java.io.File;

public class FileSystemInitializer {
    private String directoryPath;

    public FileSystemInitializer(){
        directoryPath = "./PaintData";
    }

    public void initFileSystem(){
        boolean isExist;
        //用户根文件夹
        String dataDirectoryPath = directoryPath;

        File dataDirFile = new File(dataDirectoryPath);

        //判断文件夹是否存在
        isExist = dataDirFile.exists();
        if(!isExist){
            System.out.println("The PaintData folder does not exist, now we are trying to create a one...");

            if(!dataDirFile.mkdir()){
                System.out.println("Create folder Failed!");
            } else{
                System.out.println("Create Success!");
            }
        }
        else{
            System.out.println("The PaintData folder exists.");
        }

    }
}
