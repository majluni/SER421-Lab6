package majluni_dghowart.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView browser = findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient());
        browser.setHorizontalScrollBarEnabled(true);
        browser.setVerticalScrollBarEnabled(true);
        browser.setWebContentsDebuggingEnabled(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl(getString(R.string.wvURL));
    }
}
