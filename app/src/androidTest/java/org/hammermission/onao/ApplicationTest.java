package org.hammermission.onao;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest extends ActivityInstrumentationTestCase2<CardActivity> {

    private CardActivity mActivity;

    public ApplicationTest() {
        super(CardActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }

    @Test
    public void testCardState() {
        onView(withId(R.id.kiswahili)).check(matches(withText("parachichi")));
        //onView(withId(R.id.picture)).check(matches(id withId(R.drawable.avocado)));
        onView(withId(R.id.english)).check(matches(withText("avocado")));
        onView(withId(R.id.english)).check(matches(
                withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        // Show english
        onView(withId(R.id.picture)).perform(ViewActions.click());
        onView(withId(R.id.english)).check(matches(
                withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        // Move to next card
        onView(withId(R.id.picture)).perform(ViewActions.click());
        onView(withId(R.id.kiswahili)).check(matches(withText("tikiti")));
        //onView(withId(R.id.picture)).check(matches(id withId(R.drawable.watermellon)));
        onView(withId(R.id.english)).check(matches(withText("watermelon")));
        onView(withId(R.id.english)).check(matches(
                withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
    }
}
