package com.ray.mvvm.sample.view.list.vm.module;

import android.support.v7.widget.LinearLayoutManager;

import com.ray.mvvm.lib.di.modules.LayoutManagerModule;
import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.lib.widget.anotations.ListType;
import com.ray.mvvm.sample.adapter.SimpleTestListAdapter;
import com.ray.mvvm.sample.view.list.contract.SimpleListContract;
import com.ray.mvvm.sample.view.list.presenter.SimpleListP;
import com.ray.mvvm.sample.view.list.vm.SimpleListVM;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(includes = LayoutManagerModule.class)
public final class SimpleListVMModule {

    private SimpleListContract.View view;

    public SimpleListVMModule(SimpleListContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    SimpleListVM provideVM(SimpleListP presenter, @Named(ListType.VERTICAL) LinearLayoutManager layoutManager) {
        return new SimpleListVM(presenter, view, layoutManager, new SimpleTestListAdapter(view));
    }

}