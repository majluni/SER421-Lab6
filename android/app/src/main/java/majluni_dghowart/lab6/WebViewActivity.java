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
        //Get name from previous activity
        final String name = getIntent().getStringExtra("name");
        //Enable webview browser contents such as debugging scroll bars etc
        browser = findViewById(R.id.webView);
        browser.setHorizontalScrollBarEnabled(true);
        browser.setVerticalScrollBarEnabled(true);

        browser.setWebContentsDebuggingEnabled(true);

        //Create the webChromeClient and enable javascript, URL file access, and DOM storage
        browser.setWebChromeClient(new WebChromeClient());
        WebSettings web = browser.getSettings();

        web.setAllowUniversalAccessFromFileURLs(true);
        web.setDomStorageEnabled(true);
        web.setJavaScriptEnabled(true);
        //Once the page is done loading manipulate the DOM used: https://stackoverflow.com/questions/3149216/how-to-listen-for-a-webview-finishing-loading-a-url by: ian
        browser.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url){
                browser.evaluateJavascript("changeName(\""+ name+ "\")", null);
                browser.evaluateJavascript("welcomeUser()",null);
            }
        });
        //Load url and add Javascript interface
        browser.loadUrl("file:///android_asset/html/clue.html");
        browser.addJavascriptInterface(new JSInterface(this), "Android");
    }
}