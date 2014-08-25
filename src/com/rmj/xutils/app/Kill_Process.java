package com.rmj.xutils.app;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Android中，虽然有很多方法（API或者shell命令）杀死后台`service`,
 * 但是仍然有很多程序几秒内再次启动，导致无法真正的杀死。
 * 这里主要着重介绍如何像 360 一样杀死Android后台服务，而不会再次启动。
 * Created by G11 on 2014/6/11.
 */
public class Kill_Process {

    /**
     * 已知的 kill 后台应用程序的方法
     * android.os.Process.killProcess(pid);
     * activityManager.killBackgroundProcesses(pkgName);
     * kill -9 pid
     * 这三种方法都可以“杀死”后台应用程序，但是都会自启动
     * 对于前面两种直接使用Android的API就行了，所以就不多介绍了。
     * 这里稍微介绍一下 最后一个方法的用法： kill -9 pid;
     */
    public void method_1(String pid) {
            Process sh = null;
            DataOutputStream os = null;
            try {
                sh = Runtime.getRuntime().exec("su");
                os = new DataOutputStream(sh.getOutputStream());
                final String Command = "kill -9 " + pid + "\n";
                os.writeBytes(Command);
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                sh.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    /**
     * 杀死后台service而不自启动： am （Activity Manager）命令是Android系统中/system/bin/目录下的一条命令。
     * 不仅可以在终端下启动一个应用程序，还可以启动Service，发送 broadcast以及Intent action ，force stop process 等等，功能非常强大。
     * 这里我们要用到一个功能就是强制停止应用程序！
     * 对于命令 am 的介绍与用法，官网给的非常清楚，请参照Android 官网： http://developer.android.com/tools/help/adb.html#am
     * 我们用到的方法和功能是：am force-stop <PACKAGE>
     */
    public void method_2(String pkgName) {
            Process sh = null;
            DataOutputStream os = null;
            try {
                sh = Runtime.getRuntime().exec("su");
                os = new DataOutputStream(sh.getOutputStream());
                final String Command = "am force-stop "+pkgName+ "\n";
                os.writeBytes(Command);
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                sh.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
