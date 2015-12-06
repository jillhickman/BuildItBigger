package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.jillhickman.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by jillhickman on 11/28/15.
 */
class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;

    // Using AsyncResponse interface to get results back to MainActivity class
    public interface AsyncResponse {
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;

    public EndpointsAsyncTask(AsyncResponse delegate){
        this.delegate = delegate;
    }


    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {

            //Connecting my app to the deployed backend
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1145.appspot.com/_ah/api/");

            myApiService = builder.build();
        }


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
    }
}
