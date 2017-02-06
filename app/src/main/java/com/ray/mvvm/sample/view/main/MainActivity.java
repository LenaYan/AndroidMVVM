package com.ray.mvvm.sample.view.main;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.ray.mvvm.lib.view.base.page.BaseDIActivity;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.view.main.contract.DaggerMainContract_Comp;
import com.ray.mvvm.sample.view.main.contract.MainContract;
import com.ray.mvvm.sample.view.main.vm.MainVM;
import com.ray.mvvm.sample.view.main.vm.module.MainVMModule;
import com.tbruyelle.rxpermissions.RxPermissions;

import javax.inject.Inject;

import rx.subjects.Subject;

public final class MainActivity extends BaseDIActivity implements MainContract.View {

    @Inject MainVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindLayout(R.layout.activity_main, viewModel, false);
        viewModel.init();
        viewModel.requestPermission(RxPermissions.getInstance(this));
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
    public void showPermissionDialog(Subject<Boolean, Boolean> subject) {
        new AlertDialog.Builder(this)
                .setTitle("Permission request")
                .setMessage("We need storage permissions.")
                .setNegativeButton("Allow", (dialogInterface, i) -> subject.onNext(true))
                .setPositiveButton("Cancel", (dialogInterface, i) -> finish())
                .show();
    }
}
