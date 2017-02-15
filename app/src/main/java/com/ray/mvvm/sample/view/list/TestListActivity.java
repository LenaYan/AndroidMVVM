package com.ray.mvvm.sample.view.list;

import android.os.Bundle;
import android.support.test.espresso.IdlingResource;
import android.view.View;

import com.ray.mvvm.lib.view.base.page.BaseDIActivity;
import com.ray.mvvm.lib.view.base.view.IRedirect;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.model.model.TestEntity;
import com.ray.mvvm.sample.test.SimpleIdlingResource;
import com.ray.mvvm.sample.view.list.contract.DaggerTestListContract_Comp;
import com.ray.mvvm.sample.view.list.contract.TestListContract;
import com.ray.mvvm.sample.view.list.vm.TestListVM;
import com.ray.mvvm.sample.view.list.vm.module.TestListVMModule;

import javax.inject.Inject;

public class TestListActivity extends BaseDIActivity implements TestListContract.View {

    public SimpleIdlingResource idlingResource;

    @Inject
    TestListVM viewModel;

    public static void start(IRedirect redirect) {
        redirect.intent(TestListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindLayout(R.layout.activity_test_list, viewModel);
        idlingResource = new SimpleIdlingResource(false);
        viewModel.setIdlingResource(idlingResource);
        viewModel.startRequest();
    }

    @Override
    public void buildComp() {
        DaggerTestListContract_Comp
                .builder()
                .activityComp(getActivityComp())
                .testListVMModule(new TestListVMModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onItemClick(int position, View view, TestEntity testEntity) {
        showToast(testEntity.getName());
        viewModel.startRefreshRequestAuto();
    }

    public IdlingResource getIdlingResource() {
        return idlingResource;
    }

}
