package com.ray.mvvm.sample.view.simple.contract;

import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.lib.model.http.ExObserver;
import com.ray.mvvm.lib.presenter.IPresenter;
import com.ray.mvvm.lib.view.base.comp.ActivityComp;
import com.ray.mvvm.lib.view.base.view.IView;
import com.ray.mvvm.sample.model.model.sample.TestEntity;
import com.ray.mvvm.sample.view.simple.SimpleDataPageActivity;
import com.ray.mvvm.sample.view.simple.vm.module.SimpleDataPageVMModule;

import dagger.Component;

public interface SimpleDataPageContract {

    @PerActivity
    @Component(modules = {SimpleDataPageVMModule.class}, dependencies = ActivityComp.class)
    interface Comp extends ActivityComp {
        void inject(SimpleDataPageActivity activity);
    }

    interface View extends IView {
    }

    interface Presenter extends IPresenter {
        void requstData(ExObserver<TestEntity> observer);
    }

}
