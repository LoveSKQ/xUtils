package com.rmj.xutils.service;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by G11 on 2014/6/18.
 */
public class ServiceStatus {

    public static boolean isServiceRunning(Context context,String serviename){
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> infos = am.getRunningServices(100);
        for(ActivityManager.RunningServiceInfo info :infos){
            String classname = info.service.getClassName();
            if(serviename.equals(classname)){
                return true;
            }
        }
        return false;
    }
}
