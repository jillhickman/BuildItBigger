package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.jillhickman.jokedisplay.JokeActivity;


public class MainActivity extends ActionBarActivity implements EndpointsAsyncTask.AsyncResponse{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
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

    public void tellJoke(View view){
//        JokeGenerator myJokeGenerator = new JokeGenerator();
//        Toast.makeText(this, myJokeGenerator.getJoke(), Toast.LENGTH_SHORT).show();


//        Intent intent = new Intent(this, JokeActivity.class);
//        JokeGenerator jokeSource = new JokeGenerator();
//        String joke = jokeSource.getJoke();
//        intent.putExtra(JokeActivity.JOKE_KEY, joke);
//        startActivity(intent);

        //Calling the EndpointAsyncTask here when button is pushed.
        //Getting the results to fire an intent
//        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.AsyncResponse() {
//            @Override
//            public void processFinish(String output) {
//
//            }
//        }).execute(new Pair<Context, String>(this, "Manfred"));

//        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.AsyncResponse() {
//            @Override
//            public void processFinish(String output) {
//                Intent intent = new Intent(getApplicationContext(), JokeActivity.class);
////                JokeGenerator jokeSource = new JokeGenerator();
////                String joke = jokeSource.getJoke();
//                intent.putExtra(JokeActivity.JOKE_KEY, output);
//                startActivity(intent);
//            }
//        });
//
//        endpointsAsyncTask.execute(new Pair<Context, String>(this, "Jill"));

        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, "Jill"));

    }


    @Override
    public void processFinish(String output) {
        Toast.makeText(this, output, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY, output);
        startActivity(intent);
    }
}
