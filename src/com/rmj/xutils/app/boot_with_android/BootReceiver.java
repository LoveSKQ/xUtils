package com.rmj.xutils.app.boot_with_android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.rmj.xutils.MainActivity;

/**
 * Created by G11 on 2014/8/25.
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
            Intent newIntent = new Intent(context, MainActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  //注意，必须添加这个标记，否则启动会失败
            context.startActivity(newIntent);
        }
    }
}
