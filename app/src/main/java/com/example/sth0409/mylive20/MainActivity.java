package com.example.sth0409.mylive20;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.JavascriptInterface;

import com.example.sth0409.mylive20.CardSlidePanel.Main2Activity;
import com.example.sth0409.mylive20.RongIM.RongIM_MainActivity;
import com.example.sth0409.mylive20.Ui.LiveActivity;
import com.example.sth0409.mylive20.Ui.VideoActivity;

public class MainActivity extends AppCompatActivity {
    private WebView contentWebView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // before();
        contentWebView = (WebView) findViewById(R.id.webview);
        contentWebView.getSettings().setUseWideViewPort(true);
        contentWebView.getSettings().setLoadWithOverviewMode(true);
        // 启用javascript
        contentWebView.getSettings().setJavaScriptEnabled(true);
        contentWebView.getSettings().setSupportZoom(true);//支持放大缩小
        // 从assets目录下面的加载html
        contentWebView.loadUrl("file:///android_asset/webforlive.html");
        contentWebView.addJavascriptInterface(MainActivity.this, "android");
    }

    @JavascriptInterface

    public void startOpenVideoFunction() {
        //子线程
        runOnUiThread(new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }
    @JavascriptInterface
    public void startOpenLiveFunction() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent(MainActivity.this, LiveActivity.class);
                startActivity(intent1);
            }
        });

    }
    @JavascriptInterface
    public void startOpenRongIMFunction() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent(MainActivity.this, RongIM_MainActivity.class);
                startActivity(intent1);
            }
        });

    }
    private void before() {
        //        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @OverrideRongIM
//            public void onClick(View v) {
//                Intent intent=new Intent(RongIM_MainActivity.this, VideoActivity.class);
//                startActivity(intent);
//            }
//        });
//        this.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                 contentWebView.loadUrl("javascript:javacalljswith(" + "'http://blog.csdn.net/Leejizhou'" + ")");
//            }
//        });
    }
}