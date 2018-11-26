package com.example.dhowa.ser421;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        final String name = getIntent().getStringExtra("name");

        browser = (WebView)findViewById(R.id.webView);
        browser.setHorizontalScrollBarEnabled(true);
        browser.setVerticalScrollBarEnabled(true);

        browser.setWebContentsDebuggingEnabled(true);

        browser.setWebChromeClient(new WebChromeClient());
        WebSettings web = browser.getSettings();

        web.setAllowUniversalAccessFromFileURLs(true);
        web.setDomStorageEnabled(true);
        web.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url){
                System.out.println("name");
                browser.evaluateJavascript("changeName(\""+ name+ "\")", null);
                browser.evaluateJavascript("welcomeUser()",null);

            }}
        );
        System.out.println("user");
        browser.loadUrl("file:///android_asset/html/clue.html");

    }
}