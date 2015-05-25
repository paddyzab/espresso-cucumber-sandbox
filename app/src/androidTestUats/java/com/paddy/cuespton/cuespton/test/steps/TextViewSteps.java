package com.paddy.cuespton.cuespton.test.steps;

import com.paddy.cuespton.cuespton.R;
import cucumber.api.java.en.Then;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static com.paddy.cuespton.cuespton.test.matchers.BasicMatchers.allOf;

public class TextViewSteps {

    @Then("I expect to see \"([^\"]*)\" as result$")
    public static void I_expect_to_see_as_result(final String result) {
        onView(allOf(withId(R.id.textViewResult), withText(result))).check(matches(isDisplayed()));
    }

}
