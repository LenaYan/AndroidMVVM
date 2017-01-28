package com.ray.mvvm.sample.view.simple.vm.module;


import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.sample.view.simple.contract.SimpleDataPageContract;
import com.ray.mvvm.sample.view.simple.presenter.SimpleDataPageP;
import com.ray.mvvm.sample.view.simple.vm.SimpleDataPageVM;

import dagger.Module;
import dagger.Provides;

@Module
public final class SimpleDataPageVMModule {

    private SimpleDataPageContract.View view;

    public SimpleDataPageVMModule(SimpleDataPageContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    SimpleDataPageVM provideVM(SimpleDataPageP presenter) {
        return new SimpleDataPageVM(presenter, view);
    }

}