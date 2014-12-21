package com.paddy.cuespton.cuespton;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@CucumberOptions(features = "features", tags = {"~@ignore"})
public class Config extends ActivityInstrumentationTestCase2 {

    private static boolean isFirstRun = true;
    public static Instrumentation instrumentation;

    public Config() {
        super(ActivityLogin.class);
    }

    @Before
    public void before() throws Exception {
        instrumentation = getInstrumentation();

        if (isFirstRun) {
            initializeEspresso();
            isFirstRun = false;
        } else {
            initializeEspresso();
        }
    }

    @After
    public void after() throws Throwable {
        finishOpenActivities();
    }

    private void initializeEspresso() {
//        Espresso.setFailureHandler(new CustomFailureHandler());
        startFirstActivity();
    }

    private void startFirstActivity() {
        getActivity();
    }

    private void finishOpenActivities() {
        ActivityFinisher.finishOpenActivities();
    }
}
