package com.ray.mvvm.sample.view.simple;

import android.os.Bundle;

import com.ray.mvvm.lib.view.base.page.BaseDIActivity;
import com.ray.mvvm.lib.view.base.view.IRedirect;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.view.simple.contract.DaggerSimpleDataPageContract_Comp;
import com.ray.mvvm.sample.view.simple.contract.SimpleDataPageContract;
import com.ray.mvvm.sample.view.simple.vm.SimpleDataPageVM;
import com.ray.mvvm.sample.view.simple.vm.module.SimpleDataPageVMModule;

import javax.inject.Inject;

public class SimpleDataPageActivity extends BaseDIActivity implements SimpleDataPageContract.View {

    @Inject SimpleDataPageVM viewModel;

    public static void start(IRedirect redirect) {
        Bundle bundle = new Bundle();
        redirect.intent(SimpleDataPageActivity.class, bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindLayout(R.layout.activity_simple_data_page, viewModel);
        viewModel.startRefreshRequestAuto();
    }

    @Override
    public void buildComp() {
        DaggerSimpleDataPageContract_Comp
                .builder()
                .activityComp(getActivityComp())
                .simpleDataPageVMModule(new SimpleDataPageVMModule(this))
                .build()
                .inject(this);
    }
}
