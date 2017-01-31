package com.ray.mvvm.sample.view.list.vm.module;

import android.support.v7.widget.LinearLayoutManager;

import com.ray.mvvm.lib.di.modules.LayoutManagerModule;
import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.lib.widget.anotations.ListType;
import com.ray.mvvm.sample.adapter.TestListAdapter;
import com.ray.mvvm.sample.view.list.contract.TestListContract;
import com.ray.mvvm.sample.view.list.presenter.TestListP;
import com.ray.mvvm.sample.view.list.vm.TestListVM;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(includes = LayoutManagerModule.class)
public final class TestListVMModule {

    private TestListContract.View view;

    public TestListVMModule(TestListContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    TestListVM provideVM(TestListP presenter, @Named(ListType.VERTICAL) LinearLayoutManager layoutManager) {
        return new TestListVM(presenter, view, layoutManager, new TestListAdapter(view));
    }

}