package com.paddy.cuespton.cuespton.test.steps;

import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;
import com.paddy.cuespton.cuespton.R;
import cucumber.api.java.en.Then;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;

public class ButtonsSteps {

    @Then("^I click on login button$")
    public static void I_click_on_login_button() {
        onView(ViewMatchers.withId(R.id.buttonLogin)).perform(click());
    }

    @Then("^I click on submit button")
    public static void I_click_on_submit_button() {
        onView(ViewMatchers.withId(R.id.buttonLogin)).perform(click());
    }
}
