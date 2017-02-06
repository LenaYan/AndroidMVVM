package com.ray.mvvm.sample.view.main.contract;

import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.lib.presenter.IPresenter;
import com.ray.mvvm.lib.view.base.comp.ActivityComp;
import com.ray.mvvm.lib.view.base.view.IView;
import com.ray.mvvm.sample.view.main.MainActivity;
import com.ray.mvvm.sample.view.main.vm.module.MainVMModule;

import dagger.Component;
import rx.subjects.Subject;

public interface MainContract {

    @PerActivity
    @Component(modules = {MainVMModule.class}, dependencies = ActivityComp.class)
    interface Comp extends ActivityComp {
        void inject(MainActivity activity);
    }

    interface View extends IView {
        void showPermissionDialog(Subject<Boolean, Boolean> subject);
    }

    interface Presenter extends IPresenter {
    }

}
