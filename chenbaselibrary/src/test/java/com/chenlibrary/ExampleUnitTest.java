package com.chenlibrary;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chenlibrary.okhttp.BaseBean;
import com.chenlibrary.okhttp.ChenOkHttp;
import com.chenlibrary.okhttp.ChenResultCallBack;
import com.chenlibrary.testbean.UserInfoJsonBean;
import com.chenlibrary.utils.ChenLog;

import org.junit.Test;
import org.junit.runner.manipulation.Ordering;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private static final String url = "http://192.168.1.107:8080/test_war/userInfo.json";

    private static final String videoUrl = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}