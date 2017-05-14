package com.equality.comm;

import android.app.Application;
import android.content.Context;

/**
 * Created by neil on 2017/5/1.
 * 公共的context
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext()
    {
        return context;
    }
}
