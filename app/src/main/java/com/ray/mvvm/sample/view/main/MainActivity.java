package com.ray.mvvm.sample.view.main;

import android.os.Bundle;
import android.view.View;

import com.ray.mvvm.lib.view.base.page.BaseDIActivity;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.model.model.SampleEntity;
import com.ray.mvvm.sample.view.main.contract.DaggerMainContract_Comp;
import com.ray.mvvm.sample.view.main.contract.MainContract;
import com.ray.mvvm.sample.view.main.vm.MainVM;
import com.ray.mvvm.sample.view.main.vm.module.MainVMModule;

import javax.inject.Inject;

public final class MainActivity extends BaseDIActivity implements MainContract.View {

    @Inject MainVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindLayout(R.layout.activity_main, viewModel, false);
        viewModel.init();
    }

    @Override
    public void buildComp() {
        DaggerMainContract_Comp
                .builder()
                .activityComp(getActivityComp())
                .mainVMModule(new MainVMModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onItemClick(int position, View view, SampleEntity sampleEntity) {
        intent(sampleEntity.gettClass());
    }
}
