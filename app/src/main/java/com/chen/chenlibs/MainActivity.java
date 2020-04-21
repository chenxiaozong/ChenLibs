package com.chen.chenlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chenlibrary.okhttp.BaseBean;
import com.chenlibrary.okhttp.ChenOkHttp;
import com.chenlibrary.okhttp.ChenResultCallBack;
import com.chenlibrary.utils.ChenLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChenOkHttp.getInstance().doGet("www.baidu.com").onResult(null, new ChenResultCallBack<BaseBean>() {
            @Override
            public void onSuccess(BaseBean bean) {
                ChenLog.i("tag:",bean.body);
            }
        });


    }
}
