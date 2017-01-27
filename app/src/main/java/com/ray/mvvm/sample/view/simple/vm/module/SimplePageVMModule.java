package com.ray.mvvm.sample.view.simple.vm.module;


import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.sample.view.simple.contract.SimplePageContract;
import com.ray.mvvm.sample.view.simple.presenter.SimplePageP;
import com.ray.mvvm.sample.view.simple.vm.SimplePageVM;

import dagger.Module;
import dagger.Provides;

@Module
public final class SimplePageVMModule {

    private SimplePageContract.View view;

    public SimplePageVMModule(SimplePageContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    SimplePageVM provideVM(SimplePageP presenter) {
        return new SimplePageVM(presenter, view);
    }

}