package com.ray.mvvm.sample.view.event;

import android.os.Bundle;

import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.view.event.contract.EventBusContract;
import com.ray.mvvm.sample.view.event.contract.DaggerEventBusContract_Comp;
import com.ray.mvvm.sample.view.event.vm.EventBusVM;
import com.ray.mvvm.sample.view.event.vm.module.EventBusVMModule;
import com.ray.mvvm.lib.view.base.page.BaseDIActivity;
import com.ray.mvvm.lib.view.base.view.IRedirect;

import javax.inject.Inject;

import android.app.Activity;

public class EventBusActivity extends BaseDIActivity implements EventBusContract.View {

    @Inject EventBusVM viewModel;

    public static void start(IRedirect redirect) {
        Bundle bundle = new Bundle();
        redirect.intent(EventBusActivity.class, bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindLayout(R.layout.activity_event_bus, viewModel);
    }

    @Override
    public void buildComp() {
        DaggerEventBusContract_Comp
                .builder()
                .activityComp(getActivityComp())
                .eventBusVMModule(new EventBusVMModule(this))
                .build()
                .inject(this);
    }
}
