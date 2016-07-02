package com.appniche.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.StandaloneActionMode;
import android.util.Log;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class JokeDisplayActivity extends AppCompatActivity {
    public static String LOG_TAG = JokeDisplayActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_display);

        Intent intent = getIntent();
        String joke = "No Jokes till now";
        if(intent!=null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            joke = intent.getStringExtra(Intent.EXTRA_TEXT);
        }
        TextView textView = (TextView) findViewById(R.id.joke_text);
        textView.setText(joke);

    }
}
