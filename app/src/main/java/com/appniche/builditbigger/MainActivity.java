package com.appniche.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

//import com.appniche.JokeActivity;
import com.appniche.jokedisplay.JokeDisplayActivity;

import static android.R.attr.start;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.os.Build.VERSION_CODES.M;
import static com.appniche.builditbigger.R.id.progressBar;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "after setting activity main");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* this is step 1 code, creating a java library & calling by button click
    public void tellJoke(View view){
        JokeActivity jokeActivity = new JokeActivity();
        Toast.makeText(this, jokeActivity.getJoke(), Toast.LENGTH_SHORT).show();
    }*/

    // This is step 2 Code.
    /*public void tellJoke(View view){
        JokeActivity jokeActivity = new JokeActivity();
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, jokeActivity.getJoke());
        startActivity(intent);
    }*/

    //this is for step 3
    // not working, look into it
//    public static void tellJoke(Context context, ProgressBar progressBar){
//        Log.d(LOG_TAG, " inside tell joke method");
//        progressBar.setVisibility(View.VISIBLE);// this line is same as onPreExecute()
//        new EndpointsAsyncTask(context,progressBar).execute();
//    }

}
