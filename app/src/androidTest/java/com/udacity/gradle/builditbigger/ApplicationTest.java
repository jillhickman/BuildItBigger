package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import com.example.JokeGenerator;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> implements EndpointsAsyncTask.AsyncResponse {
    public ApplicationTest() {
        super(Application.class);
    }


    public void testJokeAsyncTask() throws Throwable {

        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void processFinish(String output) {
        boolean found = false;
        for (String joke : JokeGenerator.myStrings){
            boolean test = TextUtils.equals(output, joke);
            if (test == true){
                found = true;
                break;
            }
        }
        assertEquals(true, found);
    }
}