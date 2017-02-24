package com.ray.mvvm.sample.view.list.contract;

import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.lib.presenter.IPresenter;
import com.ray.mvvm.lib.view.base.comp.ActivityComp;
import com.ray.mvvm.lib.view.base.view.IView;
import com.ray.mvvm.sample.model.model.sample.TestEntity;
import com.ray.mvvm.sample.view.common.TestCellView;
import com.ray.mvvm.sample.view.list.SimpleListActivity;
import com.ray.mvvm.sample.view.list.vm.module.SimpleListVMModule;

import java.util.List;

import dagger.Component;

public interface SimpleListContract {

    @PerActivity
    @Component(modules = {SimpleListVMModule.class}, dependencies = ActivityComp.class)
    interface Comp extends ActivityComp {
        void inject(SimpleListActivity activity);
    }

    interface View extends IView, TestCellView {
    }

    interface Presenter extends IPresenter {
        List<TestEntity> mockList(int count);
    }

}
