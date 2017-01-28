package com.ray.mvvm.sample.view.event.contract;

import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.lib.presenter.IPresenter;
import com.ray.mvvm.lib.view.base.comp.ActivityComp;
import com.ray.mvvm.lib.view.base.view.IView;
import com.ray.mvvm.sample.view.event.EventBusActivity;
import com.ray.mvvm.sample.view.event.vm.module.EventBusVMModule;

import dagger.Component;

public interface EventBusContract {

    @PerActivity
    @Component(modules = {EventBusVMModule.class}, dependencies = ActivityComp.class)
    interface Comp extends ActivityComp {
        void inject(EventBusActivity activity);
    }

    interface View extends IView {
    }

    interface Presenter extends IPresenter {
        void sendEvent();
    }

}
