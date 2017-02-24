package com.ray.mvvm.sample.view;

import android.content.Context;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.MediumTest;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.view.simple.SimplePageActivity;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Android Studio.
 * ProjectName: AndroidMVVM
 * Author:  Rayman
 * Date: 17/02/2017
 * Time: 10:05 AM
 * \ --------------------------------------------
 * \| The only thing that is constant is change!  |
 * \ --------------------------------------------
 * \  \
 * \   \   \_\_    _/_/
 * \    \      \__/
 * \           (oo)\_______
 * \           (__)\       )\/\
 * \               ||----w |
 * \               ||     ||
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
public class SimplePageTest {

    @Rule
    public ActivityTestRule<SimplePageActivity> testRule = new ActivityTestRule<>(SimplePageActivity.class, false, true);

    @Before
    public void init() {
        System.out.println("Test started");
        Context testContext = InstrumentationRegistry.getContext();
        Context appContext = InstrumentationRegistry.getTargetContext();
        Assert.assertNotNull(testContext);
        Assert.assertNotNull(appContext);
        Assert.assertEquals(testContext.getPackageName(), appContext.getPackageName());
    }

    @Test
    public void testSimplePage() {
        Espresso.onView(ViewMatchers.withId(R.id.input_layout)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @After
    public void afterTest() {
        System.out.println("Test ended");
    }

}
