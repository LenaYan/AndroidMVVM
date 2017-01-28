package com.ray.mvvm.sample.view.event.vm.module;


import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.sample.view.event.contract.EventBusContract;
import com.ray.mvvm.sample.view.event.presenter.EventBusP;
import com.ray.mvvm.sample.view.event.vm.EventBusVM;

import dagger.Module;
import dagger.Provides;

@Module
public final class EventBusVMModule {

    private EventBusContract.View view;

    public EventBusVMModule(EventBusContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    EventBusVM provideVM(EventBusP presenter) {
        return new EventBusVM(presenter, view);
    }

}