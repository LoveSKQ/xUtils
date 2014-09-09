package com.rmj.xutils.activity;

import android.app.Activity;
import android.os.Bundle;
import com.rmj.xutils.R;

/**
 * Created by G11 on 2014/9/5.
 */
public class BaseActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}