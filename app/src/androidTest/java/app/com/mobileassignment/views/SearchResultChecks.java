package app.com.mobileassignment.views;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsAnything.anything;
import static org.hamcrest.core.StringContains.containsString;

import static java.lang.Thread.sleep;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import app.com.mobileassignment.R;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class SearchResultChecks {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void FirstExactMatchUntilComma() {
        //step: On the search page, "'t Hoeksken" is written in the search bar.
        //expected: The exact result "'t Hoeksken, BE" should be returned
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.search), isDisplayed()));



        appCompatEditText.perform(replaceText("'t Hoeksken"), closeSoftKeyboard());
        SystemClock.sleep(2000); //Wait until result will be loaded

        onView(allOf(withId(R.id.cityName), withText("'t Hoeksken, BE"))).check(matches(isDisplayed()));




    }

    @Test
    public void FirstExactMatchWithComma() {
        //step:On the search page, "'t Hoeksken, BE" is written in the search bar.
        //expected:The exact result "'t Hoeksken, BE" should be returned
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.search), isDisplayed()));



        appCompatEditText.perform(replaceText("'t Hoeksken, BE"), closeSoftKeyboard());
        SystemClock.sleep(2000); //Wait until result will be loaded

        onView(allOf(withId(R.id.cityName), withText("'t Hoeksken, BE"))).check(matches(isDisplayed()));




    }

    @Test
    public void FirstExactMatchWithMiddleName() {
        //step: On the search page, "'Hoeksken" is written in the search bar.
        //expected: The exact result "'t Hoeksken, BE" should be returned
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.search), isDisplayed()));

        appCompatEditText.perform(replaceText("'Hoeksken"), closeSoftKeyboard());
        SystemClock.sleep(2000); //Wait until result will be loaded

        onView(allOf(withId(R.id.cityName), withText("'t Hoeksken, BE"))).check(matches(isDisplayed()));




    }

}
