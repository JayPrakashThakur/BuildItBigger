package com.appniche.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@MediumTest
@RunWith(AndroidJUnit4.class)

public class AsyncTaskFunctionalTest {

    @Test
    public void taskResult() throws Exception {
        // Context of the app under test. this is written example
        /*Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.appniche.builditbigger", appContext.getPackageName());*/
        String joke = new EndpointsAsyncTask(null).doInBackground();
        assertFalse(joke.isEmpty());

    }
}