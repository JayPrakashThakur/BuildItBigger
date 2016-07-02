package com.appniche.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.appniche.builditbigger.backend.myApi.MyApi;
import com.appniche.jokedisplay.JokeDisplayActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import static android.R.attr.name;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {

    private static String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();

    private static MyApi myApiService = null;
    private Context context ;
    private ProgressBar progressBar;

    public EndpointsAsyncTask(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    /*public EndpointsAsyncTask(Context context, ProgressBar progressBar) {
        this.context = context;
        this.progressBar = progressBar;
    }*/


    /* for this, code is written in tellJoke() itself
    @Override
    protected void onPreExecute() {
        if (progressBar != null){
            progressBar.setVisibility(View.VISIBLE);
        }
    }*/

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    /*.setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });*/
                    .setRootUrl("https://build-it-bigger-1354.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }
        Log.d(LOG_TAG, "before params");

        if (params != null) {
            context = params[0];
        }
        try {
            Log.d(LOG_TAG, myApiService.fetchJoke().execute().getData());
            return myApiService.fetchJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (progressBar != null){
            progressBar.setVisibility(View.GONE);
        }
        if (context != null) {
            Intent intent = new Intent(context, JokeDisplayActivity.class);
            intent.putExtra(Intent.EXTRA_TEXT, result);
            context.startActivity(intent);
        }
    }
}

