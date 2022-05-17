package app.com.mobileassignment.views;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.annotation.Nullable;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.util.TreeIterables;
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
public class ResultsCountCheck {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void FirstSearchResultCountCheck() {
        //step: Type "A Dos C" in the search bar
        //expected: After typing "A Dos C" into the search bar, two results should be returned.
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.search), isDisplayed()));



        appCompatEditText.perform(replaceText("A Dos C"));

        SystemClock.sleep(6500);
        onView(withId(R.id.citiesList)).check(matches(withViewCount(withId(R.id.cityName), 2)));




    }

    @Test
    public void SecondSearchResultCountCheck() {
        //step: Type "TEST" in the search bar
        //expected: After typing "TEST" into the search bar, seven results should be returned.
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.search), isDisplayed()));



        appCompatEditText.perform(replaceText("TEST"));

        SystemClock.sleep(6500);
        onView(withId(R.id.citiesList)).check(matches(withViewCount(withId(R.id.cityName), 7)));




    }
    public static Matcher<View> withViewCount(final Matcher<View> viewMatcher, final int expectedCount) {
        return new TypeSafeMatcher<View>() {
            int actualCount = -1;

            @Override
            public void describeTo(Description description) {
                if (actualCount >= 0) {
                    description.appendText("With expected number of items: " + expectedCount);
                    description.appendText("\n With matcher: ");
                    viewMatcher.describeTo(description);
                    description.appendText("\n But got: " + actualCount);
                }
            }

            @Override
            public boolean matchesSafely(View root) {
                actualCount = 0;
                Iterable<View> iterable = TreeIterables.breadthFirstViewTraversal(root);
                actualCount = Lists.newArrayList(Iterables.filter(iterable, withMatcherPredicate(viewMatcher))).size();
                System.out.println(actualCount);
                System.out.println("gulbrk");
                return actualCount == expectedCount  ;
            }

        };
    }

    private static Predicate<View> withMatcherPredicate(final Matcher<View> matcher) {
        return new Predicate<View>() {
            @Override
            public boolean apply(@Nullable View view) {
                return matcher.matches(view);
            }
        };



    }





}
