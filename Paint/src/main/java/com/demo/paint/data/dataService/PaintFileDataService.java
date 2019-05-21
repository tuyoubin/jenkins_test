package com.demo.paint.data.dataService;

import com.demo.paint.entity.PaintFile;
import java.util.List;

public interface PaintFileDataService {
    /**
     * 保存图画文件
     * @param paintFile 图画文件
     * @return 是否保存成功
     */
    boolean savePaintFile(PaintFile paintFile);

    /**
     * 获取图画文件
     * @param fileName 文件名
     * @return 图画信息
     */
    PaintFile getPaintFile(String fileName);

    /**
     * 获取图画文件名列表
     * @return 所有图画文件名的列表
     */
    List<String> getPaintFileNameList();

    /**
     * 判断文件名是否已存在
     * @param fileName 文件名
     * @return 是否存在
     */
    boolean isPaintFileNameExist(String fileName);
}
