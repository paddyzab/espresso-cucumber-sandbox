package com.paddy.cuespton.cuespton.test;

import android.os.Bundle;
import com.google.android.apps.common.testing.testrunner.GoogleInstrumentation;
import cucumber.api.android.CucumberInstrumentationCore;

public class Instrumentation extends GoogleInstrumentation {

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);

        // Reading runner params
        int foo = BuildConfig.FOO;
        bundle.putInt("foo", foo);

        instrumentationCore.create(bundle);
        start();
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
