package majluni_dghowart.lab6;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

public class JSInterface {
    Context context;

    public JSInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void goBack(String history) {
        Intent mA  = new Intent(context, MainActivity.class);
        mA.putExtra("history", history);
        context.startActivity(mA);
    }
}