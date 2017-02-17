package com.ray.mvvm.sample.view;

import android.os.Build;
import android.support.test.filters.MediumTest;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.ray.mvvm.lib.view.adapter.list.base.StateListAdapter;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.view.list.TestListActivity;

import junit.framework.Assert;

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
    public ActivityTestRule<TestListActivity> testRule = new ActivityTestRule<>(TestListActivity.class, false, true);

    private TestListActivity testListActivity;

    @Before
    public void init() {
        testListActivity = testRule.getActivity();
    }

    @Test
    public void testSimpleList() {
        RecyclerView recyclerView = (RecyclerView) testListActivity.findViewById(R.id.data_list);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Assert.assertNotNull(recyclerView);
        Assert.assertNotNull(recyclerView.getAdapter());
        Assert.assertNotNull(adapter instanceof StateListAdapter);
        StateListAdapter stateListAdapter = (StateListAdapter) adapter;
        Assert.assertTrue(stateListAdapter.getItemCount() == 21);
        Assert.assertTrue(stateListAdapter.getDataCount() == 20);
    }

}
