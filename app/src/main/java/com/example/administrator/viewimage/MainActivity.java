package com.example.administrator.viewimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        //实例化WebView对象
        webview = new WebView(this);
        //设置WebView属性，能够执行Javascript脚本
        webview.getSettings().setJavaScriptEnabled(true);

        try {
            //设置打开的页面地址
            webview.loadUrl("http://192.168.0.163");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setContentView(webview);

        //在当前页面打开链接
        webview.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverrideUrlLoading(WebView view,String url)
            {
                view.loadUrl(url);
                return true;
            }
        });

        //解决 点击后无窗口弹出
        webview.setWebChromeClient(new WebChromeClient());

    }

    @Override
    public boolean onKeyDown(int keyCoder,KeyEvent event)
    {
        //页面内回退
        if((keyCoder==KeyEvent.KEYCODE_BACK) && webview.canGoBack()){
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCoder,event);
    }
}
