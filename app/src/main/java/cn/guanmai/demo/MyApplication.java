package cn.guanmai.demo;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        QbSdk.initX5Environment(getApplicationContext(), new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                Log.e("TAG", "onCoreInitFinished");
            }

            @Override
            public void onViewInitFinished(boolean b) {
                Log.e("TAG", "onViewInitFinished" + b);
            }
        });
    }
}
