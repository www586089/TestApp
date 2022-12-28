package com.zfang.testapp;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class App extends Application {

    private static View mainView = null;
    private static App INSTANCE = null;

    private ReentrantLock reentrantLock = new ReentrantLock();
    public static App get() {
        return INSTANCE;
    }

    public View getAsyncMainView() {
        if (null == mainView) {
            try {
                Log.e("zfang", "try lock");
                reentrantLock.lock();
                return mainView;
            } finally {
                Log.e("zfang", "unlock");
                reentrantLock.unlock();
            }
        }
        return mainView;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        loadView(getApplicationContext());
    }

    private void loadView(Context context) {
        AsyncTask asyncTask = new AsyncTask<Object, Object, Object>() {

            private Context ctx = null;
            @Override
            protected Void doInBackground(Object... voids) {
                try {
                    reentrantLock.lock();
                    Log.e("zfang", "async load view beign");
                    TimeUnit.MICROSECONDS.sleep(100);
                    mainView = LayoutInflater.from(context).inflate(R.layout.activity_main, null);
                    Log.e("zfang", "async load view end");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }

                return null;
            }
        };
        asyncTask.execute();
    }
}
