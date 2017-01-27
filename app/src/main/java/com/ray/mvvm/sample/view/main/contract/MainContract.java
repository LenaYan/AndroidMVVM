package com.ray.mvvm.sample.view.main.contract;

import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.lib.presenter.IPresenter;
import com.ray.mvvm.lib.view.adapter.OnItemClick;
import com.ray.mvvm.lib.view.base.comp.ActivityComp;
import com.ray.mvvm.lib.view.base.view.IView;
import com.ray.mvvm.sample.model.model.SampleEntity;
import com.ray.mvvm.sample.view.main.MainActivity;
import com.ray.mvvm.sample.view.main.vm.module.MainVMModule;

import dagger.Component;

public interface MainContract {

    @PerActivity
    @Component(modules = {MainVMModule.class}, dependencies = ActivityComp.class)
    interface Comp extends ActivityComp {
        void inject(MainActivity activity);
    }

    interface View extends IView, SampleCellView {
    }

    interface SampleCellView extends OnItemClick<SampleEntity> {
    }

    interface Presenter extends IPresenter {
    }

}
