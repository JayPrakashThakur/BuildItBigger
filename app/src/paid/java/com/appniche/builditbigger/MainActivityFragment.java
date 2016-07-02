package com.appniche.builditbigger;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

//import com.appniche.JokeActivity;
import com.appniche.builditbigger.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.appniche.jokedisplay.JokeDisplayActivity.LOG_TAG;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        Button button = (Button) root.findViewById(R.id.tell_joke_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke(getView());
            }
        });

        return root;
    }

    public void tellJoke(View view){
        Log.d(LOG_TAG, " inside tell joke method");
        progressBar.setVisibility(View.VISIBLE);// this line is same as onPreExecute()
        new EndpointsAsyncTask(progressBar).execute(getActivity());
    }

}
