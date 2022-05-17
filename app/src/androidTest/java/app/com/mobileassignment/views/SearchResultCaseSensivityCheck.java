package app.com.mobileassignment.views;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.internal.util.Checks.checkNotNull;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.core.IsAnything.anything;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.object.HasToString.hasToString;


import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;


import androidx.test.espresso.ViewInteraction;

import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.espresso.util.TreeIterables;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import app.com.mobileassignment.R;

@LargeTest
@RunWith(AndroidJUnit4.class)


public class SearchResultCaseSensivityCheck {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void FirstContainedLettersCheck() {
        //step: Type "zandak" in the search bar
        //expected: "Zandak" should be contained in the first result returned

        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.search), isDisplayed()));

        String word1 = "zandak";
        appCompatEditText.perform(replaceText(word1), closeSoftKeyboard());


        SystemClock.sleep(2000);





        onData(anything()).inAdapterView(withId(R.id.citiesList))
                .atPosition(0)
                .onChildView(withId(R.id.cityName))
                .check(matches(withText(containsString("Zandak"))));







    }


    @Test
    public void SecondContainedLettersCheck() {
        //step: Type "zAnDAK" in the search bar
        //expected: "Zandak" should be contained in the first result returned

        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.search), isDisplayed()));

        String word2 = "zAnDAK";
        appCompatEditText.perform(replaceText(word2), closeSoftKeyboard());


        SystemClock.sleep(2000);

        onData(anything()).inAdapterView(withId(R.id.citiesList))
                .atPosition(0)
                .onChildView(withId(R.id.cityName))
                .check(matches(withText(containsString("Zandak"))));










    }





}
