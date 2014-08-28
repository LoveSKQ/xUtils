package com.rmj.xutils.app;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by G11 on 2014/8/28.
 */
public class CheckUtils {
    public static boolean appIsInstalled(Context context, String pageName) {
        try {
            context.getPackageManager().getPackageInfo(pageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
