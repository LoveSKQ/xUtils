package com.rmj.xutils.file;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by G11 on 2014/7/8.
 */
public class FileOperate {

    /**
     * 删除指定目录下的所有文件
     * @param dir
     */
    public static void deleteFiles(String dir) {
        File _file = new File(dir);
        if (_file.exists()) {
            if (_file.isDirectory()) {
                File[] _files = _file.listFiles();
                for (int i=0;i<_files.length;i++) {
                    deleteFiles(_files[i].getPath());
                }
            }
            _file.delete();
        }
    }
}
