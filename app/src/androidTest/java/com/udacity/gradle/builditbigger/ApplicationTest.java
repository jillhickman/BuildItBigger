package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

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
        assertEquals("This is totally a funny joke", output);
    }
}