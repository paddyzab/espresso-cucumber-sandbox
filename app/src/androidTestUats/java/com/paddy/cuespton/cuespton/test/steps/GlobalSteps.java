package com.paddy.cuespton.cuespton.test.steps;

import cucumber.api.java.en.Then;

public class GlobalSteps {

    @Then("^I wait for (\\d+) seconds$")
    public static void I_wait_for_seconds(final long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
