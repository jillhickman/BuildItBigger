package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.jillhickman.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by jillhickman on 11/28/15.
 */
class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    // Using AsyncResponse interface to get results back to MainActivity class
    public interface AsyncResponse {
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;

    public EndpointsAsyncTask(AsyncResponse delegate){
        this.delegate = delegate;
    }


    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once

            //Connecting my app to the deployed backend
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1145.appspot.com/_ah/api/");

            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            //Calling my sayJoke from the backend
            return myApiService.sayJoke().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
    }

    //
    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}
