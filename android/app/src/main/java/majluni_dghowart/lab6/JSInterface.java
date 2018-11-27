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
    public void goBack() {
        Intent mA  = new Intent(context, MainActivity.class);
        context.startActivity(mA);
    }
}