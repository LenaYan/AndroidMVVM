package com.ray.mvvm.sample.view.list.vm;

import android.support.v7.widget.RecyclerView;

import com.ray.mvvm.lib.view.adapter.list.base.ListAdapter;
import com.ray.mvvm.lib.viewmodel.ListVM;
import com.ray.mvvm.sample.model.model.TestEntity;
import com.ray.mvvm.sample.view.list.contract.SimpleListContract;

public class SimpleListVM extends ListVM<SimpleListContract.Presenter, SimpleListContract.View, TestEntity> {

    public SimpleListVM(SimpleListContract.Presenter presenter, SimpleListContract.View view, RecyclerView.LayoutManager layoutManager, ListAdapter<TestEntity> adapter) {
        super(presenter, view, layoutManager, adapter);
        adapter.setList(presenter.mockList(20));
    }

}