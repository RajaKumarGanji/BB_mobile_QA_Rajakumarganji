package app.com.mobileassignment.views;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import app.com.mobileassignment.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ApplicationLaunch {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ApplicationHeaderCheck() {

        //step: The application is started.
        //expected: " the Mobile Assignment text in the Header should be seen."

        onView(
                allOf(withText("Mobile Assignment"),
                        withParent(allOf(withId(R.id.action_bar),
                                withParent(withId(R.id.action_bar_container)))),
                        isDisplayed())).check(matches(isDisplayed()));


    }

    @Test
    public void ApplicationSearchBarCheck() {

        //step: The application is started
        //expected: the Search bar should be seen.



        onView(withId(R.id.search)).check(matches(isDisplayed()));



    }



}