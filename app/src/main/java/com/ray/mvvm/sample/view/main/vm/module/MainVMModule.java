package com.ray.mvvm.sample.view.main.vm.module;


import android.support.v7.widget.LinearLayoutManager;

import com.ray.mvvm.lib.di.modules.LayoutManagerModule;
import com.ray.mvvm.lib.di.scope.PerActivity;
import com.ray.mvvm.lib.widget.anotations.ListType;
import com.ray.mvvm.sample.adapter.SampleListAdapter;
import com.ray.mvvm.sample.view.main.contract.MainContract;
import com.ray.mvvm.sample.view.main.presenter.MainP;
import com.ray.mvvm.sample.view.main.vm.MainVM;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(includes = {LayoutManagerModule.class})
public final class MainVMModule {

    private MainContract.View view;

    public MainVMModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    MainVM provideVM(MainP presenter, @Named(ListType.VERTICAL) LinearLayoutManager layoutManager) {
        return new MainVM(presenter, view, layoutManager, new SampleListAdapter());
    }

}