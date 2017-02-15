package com.ray.mvvm.sample.view;

import android.app.Activity;
import android.os.Build;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.MediumTest;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.ray.mvvm.lib.view.adapter.list.base.StateListAdapter;
import com.ray.mvvm.sample.ActivityUtil;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.view.list.TestListActivity;
import com.ray.mvvm.sample.view.main.MainActivity;

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
 * Date: 15/02/2017
 * Time: 3:43 PM
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
public class TestListActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    private IdlingResource idlingResource;

    @Before
    public void init() {
    }

    @Test
    public void testSimpleList() {
        RecyclerView mainListView = (RecyclerView) testRule.getActivity().findViewById(R.id.data_list);
        Assert.assertEquals(5, mainListView.getAdapter().getItemCount());
        Espresso.onView(ViewMatchers.withId(R.id.data_list))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(4, ViewActions.click()));

        Activity activity = ActivityUtil.getCurrentActivity();
        Assert.assertTrue(activity instanceof TestListActivity);
        TestListActivity testListActivity = (TestListActivity) activity;
        idlingResource = testListActivity.getIdlingResource();
        Espresso.registerIdlingResources(idlingResource);
        RecyclerView recyclerView = (RecyclerView) testListActivity.findViewById(R.id.data_list);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Assert.assertNotNull(recyclerView);
        Assert.assertNotNull(recyclerView.getAdapter());
        Assert.assertNotNull(adapter instanceof StateListAdapter);
        StateListAdapter stateListAdapter = (StateListAdapter) adapter;

        idlingResource.registerIdleTransitionCallback(() -> {
            Assert.assertTrue(stateListAdapter.getItemCount() > 0);
            Assert.assertTrue(stateListAdapter.getDataCount() == 20);
            Espresso.onView(ViewMatchers.withId(R.id.data_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));
        });
    }

    @After
    public void testfinalize() {
        if (idlingResource != null)
            Espresso.unregisterIdlingResources(idlingResource);
    }

}