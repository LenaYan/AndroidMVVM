package com.ray.mvvm.sample.view.list;

import android.os.Bundle;
import android.view.View;

import com.ray.mvvm.lib.view.base.page.BaseDIActivity;
import com.ray.mvvm.lib.view.base.view.IRedirect;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.model.model.TestEntity;
import com.ray.mvvm.sample.view.list.contract.DaggerSimpleListContract_Comp;
import com.ray.mvvm.sample.view.list.contract.SimpleListContract;
import com.ray.mvvm.sample.view.list.vm.SimpleListVM;
import com.ray.mvvm.sample.view.list.vm.module.SimpleListVMModule;

import javax.inject.Inject;

public class SimpleListActivity extends BaseDIActivity implements SimpleListContract.View {

    public static final int MOCK_DATA_COUNT = 20;

    @Inject
    SimpleListVM viewModel;

    public static void start(IRedirect redirect) {
        redirect.intent(SimpleListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindLayout(R.layout.activity_simple_list, viewModel);
    }

    @Override
    public void buildComp() {
        DaggerSimpleListContract_Comp
                .builder()
                .activityComp(getActivityComp())
                .simpleListVMModule(new SimpleListVMModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onItemClick(int position, View view, TestEntity testEntity) {
        showToast(testEntity.getName());
    }

}
