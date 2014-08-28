package com.rmj.xutils.file;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by G11 on 2014/7/8.
 */
public class FileOperate {

    public static final String CACHE_DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/RMJ_xUtils";

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

    /**
     * 获得assets下面的指定文件，并拷贝到sd中（assets下的文件不能直接执行）
     * @param context
     * @param fileName
     * @return
     */
    public static File getAssetFileToCacheDir(Context context, String fileName) {
        try {
            InputStream istream = context.getAssets().open(fileName);
            File file = new File(CACHE_DIRECTORY, fileName);
            if (file.exists()) {
                file.delete();
            }
            // file.createNewFile();
            FileOutputStream ostream = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = istream.read(buffer)) > 0) {
                ostream.write(buffer, 0, length);
            }
            istream.close();
            ostream.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
