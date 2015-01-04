package com.paddy.cuespton.cuespton.test;

import android.os.Bundle;
import com.google.android.apps.common.testing.testrunner.GoogleInstrumentation;
import cucumber.api.android.CucumberInstrumentationCore;

public class Instrumentation extends GoogleInstrumentation {

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);
    private static final String TAGS_KEY = "tags";

    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);

        String tags = BuildConfig.TAGS;
        if (!tags.isEmpty()) {
            bundle.putString(TAGS_KEY, tags);
        }

        instrumentationCore.create(bundle);
        start();
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
