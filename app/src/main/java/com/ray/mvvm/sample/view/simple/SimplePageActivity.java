package com.ray.mvvm.sample.view.simple;

import android.os.Bundle;

import com.ray.mvvm.lib.view.base.page.BaseDIActivity;
import com.ray.mvvm.lib.view.base.view.IRedirect;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.view.simple.contract.DaggerSimplePageContract_Comp;
import com.ray.mvvm.sample.view.simple.contract.SimplePageContract;
import com.ray.mvvm.sample.view.simple.vm.SimplePageVM;
import com.ray.mvvm.sample.view.simple.vm.module.SimplePageVMModule;

import javax.inject.Inject;


public final class SimplePageActivity extends BaseDIActivity implements SimplePageContract.View {

    @Inject SimplePageVM viewModel;

    public static void start(IRedirect redirect) {
        Bundle bundle = new Bundle();
        redirect.intent(SimplePageActivity.class, bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindLayout(R.layout.activity_simple_page, viewModel);
    }

    @Override
    public void buildComp() {
        DaggerSimplePageContract_Comp
                .builder()
                .activityComp(getActivityComp())
                .simplePageVMModule(new SimplePageVMModule(this))
                .build()
                .inject(this);
    }
}
