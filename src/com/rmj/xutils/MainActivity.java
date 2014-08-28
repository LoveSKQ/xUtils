package com.rmj.xutils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.rmj.xutils.printer.PrinterShare;

/**
 * Created by G11 on 2014/8/25.
 */
public class MainActivity extends Activity {
    Button mSubmitBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSubmitBtn = (Button) findViewById(R.id.submit_btn);
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrinterShare.print("","",MainActivity.this);
            }
        });
    }
}