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

public class OtherCharactersCheck {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void OtherCharactersShouldntBreakTheApp(){
        //steps: Type "%" in the search bar
        //Type "&" in the search bar
        //Type "*" in the search bar
        //expected: App shouldn't crash and search page should be seen

        onView(allOf(withId(R.id.search), isDisplayed())).perform(replaceText("%"), closeSoftKeyboard());

        onView(allOf(withId(R.id.search), isDisplayed())).perform(replaceText("&"), closeSoftKeyboard());

        onView(allOf(withId(R.id.search), isDisplayed())).perform(replaceText("*"), closeSoftKeyboard());


        onView(withId(R.id.search))
                .check(matches(isDisplayed()));



        onView(
                allOf(withText("Mobile Assignment"),
                        withParent(allOf(withId(R.id.action_bar),
                                withParent(withId(R.id.action_bar_container)))),
                        isDisplayed())).check(matches(isDisplayed()));











    }
}
