package com.paddy.cuespton.cuespton.test.steps;

import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;
import com.google.android.apps.common.testing.ui.espresso.ViewInteraction;
import com.google.android.apps.common.testing.ui.espresso.matcher.BoundedMatcher;
import com.google.common.collect.Lists;
import com.paddy.cuespton.cuespton.AdapterCountrySelect;
import com.paddy.cuespton.cuespton.R;
import com.paddy.cuespton.cuespton.ViewCountrySelect;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.AllOf;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static com.google.common.base.Preconditions.checkNotNull;

public class CountriesSteps {


    @When("^I select country \"([^\"]*)\"$")
    public static void I_select_country(final String country) throws Throwable {
        onCountryWithName(country).perform(click());
    }

    private static ViewInteraction onCountryWithName(final String titleOfCalendarNote) {
        return onView(allOf(withText(titleOfCalendarNote), withAncestor(withId(R.id.listViewCounties))));
    }

    @Then("^I expect country \"([^\"]*)\" to be selected")
    public static void Country_is_selected(final String country) {
        onView(withId(R.id.listViewCounties)).check(matches(selectedCountryInCountiesList(country)));
    }

    public static Matcher<? super View> selectedCountryInCountiesList(final String country) {
        return new BoundedMatcher<View, AdapterView>(AdapterView.class) {

            @Override
            protected boolean matchesSafely(AdapterView view) {
                AdapterCountrySelect adapter = (AdapterCountrySelect) view.getAdapter();

                for (int i  = 0; i < adapter.getCount(); i++) {

                    final ViewCountrySelect viewCountrySelect = (ViewCountrySelect) adapter.getView(i, null, view);
                    final TextView textViewCountry = (TextView) viewCountrySelect.findViewById(R.id.textViewCountry);
                    final CheckBox viewCheckbox = (CheckBox) viewCountrySelect.findViewById(R.id.checkboxSelectCountry);

                    if (country.equals(textViewCountry.getText().toString())) {
                        return viewCheckbox.isChecked();
                    }
                }

                return true;
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

    public static <T> Matcher<T> allOf(final Matcher<? extends T> first, final Matcher<? extends T> second) {
        return AllOf.allOf(Lists.newArrayList(first, second));
    }

    public static Matcher<View> withAncestor(final Matcher<View> ancestorMatcher) {
        checkNotNull(ancestorMatcher);
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("has ancestor matching: ");
                ancestorMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {

                ViewParent parent = view.getParent();
                while (parent != null) {
                    if (ancestorMatcher.matches(parent)) {
                        return true;
                    }

                    parent = parent.getParent();
                }

                return false;
            }
        };
    }
}
