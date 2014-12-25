package com.paddy.cuespton.cuespton.test.steps;

import android.view.View;
import android.widget.EditText;
import com.paddy.cuespton.cuespton.R;
import cucumber.api.java.en.Then;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.clearText;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

public class EditTextSteps {

    @Then("^I type as login (\\S+)")
    public static void I_type_as_login(final String login) {
        onView(withId(R.id.editTextLogin)).perform(clearText(), typeText(login));
    }

    @Then("^I type as password (\\S+)")
    public static void I_type_as_password(final String password) {
        onView(withId(R.id.editTextPassword)).perform(clearText(), typeText(password));
    }

    @Then("^I expect error on login input field \\\"([^\\\"]*)\\\"")
    public static void I_expect_error_on_login_input_field(final String errorMessage) {
        onView(withId(R.id.editTextLogin)).check(matches(withError(errorMessage)));
    }

    public static Matcher<View> withError(final String expectedError) {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof EditText)) {
                    return false;
                }


                final String error = ((EditText) view).getError().toString();
                return expectedError.equals(error);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }
}
