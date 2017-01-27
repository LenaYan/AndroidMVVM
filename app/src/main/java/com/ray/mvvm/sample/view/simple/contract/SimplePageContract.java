package com.ray.mvvm.sample.view.simple.contract;

import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.lib.view.base.comp.ActivityComp;
import com.ray.mvvm.lib.presenter.IPresenter;
import com.ray.mvvm.lib.view.base.view.IView;
import com.ray.mvvm.sample.view.simple.vm.module.SimplePageVMModule;
import com.ray.mvvm.sample.view.simple.SimplePageActivity;

import dagger.Component;

public interface SimplePageContract {

    @PerActivity
    @Component(modules = {SimplePageVMModule.class}, dependencies = ActivityComp.class)
    interface Comp extends ActivityComp {
        void inject(SimplePageActivity activity);
    }

    interface View extends IView {
    }

    interface Presenter extends IPresenter {
    }

}
