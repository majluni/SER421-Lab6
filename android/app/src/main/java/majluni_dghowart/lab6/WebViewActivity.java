package majluni_dghowart.lab6;

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

        browser = findViewById(R.id.webView);
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
                browser.evaluateJavascript("changeName(\""+ name+ "\")", null);
                browser.evaluateJavascript("welcomeUser()",null);
            }
        });

        browser.loadUrl("file:///android_asset/html/clue.html");
        browser.addJavascriptInterface(new JSInterface(this), "Android");
    }
}
