package cn.guanmai.demo;

import androidx.appcompat.app.AppCompatActivity;
import cn.guanmai.jsbridge.X5WebView;

import android.os.Bundle;
import android.util.Log;

import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        X5WebView webView = findViewById(R.id.webView);
        webView.loadUrl("http://soft.imtt.qq.com/browser/tes/feedback.html");
        initX5WebView();
    }

    private void initX5WebView() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, true);
        QbSdk.initTbsSettings(map);
        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                Log.e("TAG", "onDownloadFinish" + i);

            }

            @Override
            public void onInstallFinish(int i) {
                Log.e("TAG", "onInstallFinish" + i);
            }

            @Override
            public void onDownloadProgress(int i) {
                Log.e("TAG", "onDownloadProgress" + i);
            }
        });
    }
}
