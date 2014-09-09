package com.rmj.xutils.printer;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.rmj.xutils.app.CheckUtils;
import com.rmj.xutils.file.FileOperate;

import java.io.File;

/**
 * PrinterShare使用方法
 * Created by G11 on 2014/8/28.
 */
public class PrinterShare {
    public static void print(String path,String type,Context context) {

        if (!CheckUtils.appIsInstalled(context, "com.dynamixsoftware.printershare")) {
            File file = FileOperate.getAssetFileToCacheDir(context, "PrinterShare.apk");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
        Intent intent = new Intent();
        ComponentName comp = new ComponentName("com.dynamixsoftware.printershare", "com.dynamixsoftware.printershare.ActivityPrintDocuments");
        intent = new Intent();
        intent.setComponent(comp);
        intent.setAction("android.intent.action.VIEW");
        intent.setType("application/msword");
        File _file = new File(Environment.getExternalStorageDirectory().getPath(),"PrinterShare.docx");
        intent.setData(Uri.fromFile(_file));
        context.startActivity(intent);
    }
}
