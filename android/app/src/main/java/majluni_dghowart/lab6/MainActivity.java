package majluni_dghowart.lab6;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String historyString = extras.getString("history");

            if (historyString != null) {
                try {
                    JSONObject historyJSON = new JSONObject(historyString);
                    String username = historyJSON.getString("username");
                    String guesses = historyJSON.getString("guesses");
                    String room = historyJSON.getString("room");
                    String suspect = historyJSON.getString("suspect");
                    String weapon = historyJSON.getString("weapon");

                    TextView history = findViewById(R.id.textView3);
                    history.setText("In the last game, " + username + " won after " + guesses +
                            "\nrounds by guessing " + suspect + " in the " + room + " with a " +
                            weapon);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onButtonClick(View v) {
        EditText text = findViewById(R.id.editText);
        String username = text.getText().toString();

        if (!username.equals("")) {
            Intent wv = new Intent(this, WebViewActivity.class);
            wv.putExtra("name",username);
            PendingIntent pend = TaskStackBuilder.create(this).addNextIntentWithParentStack(wv).getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setContentIntent(pend);
            startActivity(wv);
        }
        else {
            Button pressed = findViewById(R.id.button);
            pressed.setVisibility(View.VISIBLE);
            TextView info = findViewById(R.id.textView2);
            info.setText(R.string.info_text);
        }
    }
}
