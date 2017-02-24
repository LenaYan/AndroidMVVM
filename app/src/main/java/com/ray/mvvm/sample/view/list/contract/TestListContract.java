package com.ray.mvvm.sample.view.list.contract;

import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.lib.model.http.ExObserver;
import com.ray.mvvm.lib.model.model.ListRespEntity;
import com.ray.mvvm.lib.presenter.IPresenter;
import com.ray.mvvm.lib.view.base.comp.ActivityComp;
import com.ray.mvvm.lib.view.base.view.IView;
import com.ray.mvvm.sample.model.model.sample.TestEntity;
import com.ray.mvvm.sample.view.common.TestCellView;
import com.ray.mvvm.sample.view.list.TestListActivity;
import com.ray.mvvm.sample.view.list.vm.module.TestListVMModule;

import dagger.Component;

public interface TestListContract {

    @PerActivity
    @Component(modules = {TestListVMModule.class}, dependencies = ActivityComp.class)
    interface Comp extends ActivityComp {
        void inject(TestListActivity activity);
    }

    interface View extends IView, TestCellView {
    }

    interface Presenter extends IPresenter {
        void requestTestList(int page, ExObserver<ListRespEntity<TestEntity>> observer);
    }

}
