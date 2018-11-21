package majluni_dghowart.lab6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        EditText text = findViewById(R.id.editText);
        String username = text.getText().toString();

        if (!username.equals("")) {
            Intent wv = new Intent(this, WebViewActivity.class);
            startActivity(wv);
        }
        else {
            Button pressed = findViewById(R.id.button);
            pressed.setVisibility(View.VISIBLE);
            TextView info = findViewById(R.id.textView2);
            info.setText(getString(R.string.badUser));
        }
    }
}