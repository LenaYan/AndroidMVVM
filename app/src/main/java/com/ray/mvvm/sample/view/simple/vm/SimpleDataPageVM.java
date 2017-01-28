package com.ray.mvvm.sample.view.simple.vm;

import com.ray.mvvm.lib.viewmodel.SwipRefreshVM;
import com.ray.mvvm.sample.model.model.TestEntity;
import com.ray.mvvm.sample.view.simple.contract.SimpleDataPageContract;

public class SimpleDataPageVM extends SwipRefreshVM<SimpleDataPageContract.Presenter, SimpleDataPageContract.View, TestEntity> {


    public SimpleDataPageVM(SimpleDataPageContract.Presenter presenter, SimpleDataPageContract.View view) {
        super(presenter, view);
        setData(new TestEntity("Title", "Description", System.currentTimeMillis()));
    }

    @Override
    protected void exeRequest() {
        presenter.requstData(this);
    }

}
