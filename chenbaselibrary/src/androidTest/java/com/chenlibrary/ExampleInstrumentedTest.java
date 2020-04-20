package com.chenlibrary;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.chenlibrary.bean.VideoJsonBean;
import com.chenlibrary.okhttp.BaseBean;
import com.chenlibrary.okhttp.ChenOkHttp;
import com.chenlibrary.okhttp.ChenResultCallBack;
import com.chenlibrary.utils.ChenLog;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String url = "http://192.168.1.107:8080/test_war/userInfo.json";

    private static final String videoUrl = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.chenlibrary.test", appContext.getPackageName());
        ChenLog.i("chenxzong tet log");
    }


    @Test
    public void testPost() {

        /**
         * post Body 参数
         */
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("chen", "chenxzong");
        bodyMap.put("age", 13);
        bodyMap.put("addr", "青岛市李沧区");
        bodyMap.put("girl", false);
        String jsonBody = "{\n" +
                "        \"name\": \"chenxzong\",\n" +
                "        \"age\": 30,\n" +
                "        \"info\": \"山东省青岛市李沧区\"\n" +
                "    }";

        /**
         * headers 参数
         */
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("token", "token");

        ChenOkHttp.getInstance()
                .doPost(url)
                .addHeaders(headersMap)
                .addMapBody(bodyMap)
                .addJsonBody(jsonBody)
                .onResult(null, new ChenResultCallBack<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {

                    }
                });
    }

    @Test
    public void testGet2() {

        /**
         * get 参数键值对,内部可根据键值对拼接成 xxx?key=val&key2=val2.....
         */
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("chen", "chenxzong");
        bodyMap.put("age", 13);
        bodyMap.put("addr", "青岛市李沧区");
        bodyMap.put("girl", false);
        String jsonBody = "string";


        /**
         * header参数
         */
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("token", "token");

        /**
         * 需要拼接 url参数
         */
        ChenOkHttp.getInstance()
                .doGet(url, bodyMap)
                .addHeaders(headersMap)
                .onResult(UserInfoJsonBean.class, new ChenResultCallBack<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {
                        System.out.println(bean);
                    }

                });


    }

    @Test
    public void testGet() {
        ChenOkHttp.getInstance().doGet(videoUrl).onResult(null, new ChenResultCallBack<BaseBean>() {
            @Override
            public void onSuccess(BaseBean bean) {

                ChenLog.i("result:>>>",bean);
            }
        });
    }
}
