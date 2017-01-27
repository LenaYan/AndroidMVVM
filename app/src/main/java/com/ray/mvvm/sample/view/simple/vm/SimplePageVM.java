package com.ray.mvvm.sample.view.simple.vm;

import com.ray.mvvm.lib.viewmodel.BaseVM;
import com.ray.mvvm.sample.view.simple.contract.SimplePageContract;

public final class SimplePageVM extends BaseVM<SimplePageContract.Presenter, SimplePageContract.View> {

    public SimplePageVM(SimplePageContract.Presenter presenter, SimplePageContract.View view) {
        super(presenter, view);
    }

}
