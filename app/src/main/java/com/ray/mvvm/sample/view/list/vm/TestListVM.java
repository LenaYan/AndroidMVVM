package com.ray.mvvm.sample.view.list.vm;

import android.support.v7.widget.LinearLayoutManager;

import com.ray.mvvm.lib.view.adapter.list.base.StateListAdapter;
import com.ray.mvvm.lib.viewmodel.EndLessListRespVM;
import com.ray.mvvm.sample.model.model.TestEntity;
import com.ray.mvvm.sample.view.list.contract.TestListContract;

public class TestListVM extends EndLessListRespVM<TestListContract.Presenter, TestListContract.View, TestEntity> {

    public TestListVM(TestListContract.Presenter presenter, TestListContract.View view, LinearLayoutManager layoutManager, StateListAdapter<TestEntity> adapter) {
        super(presenter, view, layoutManager, adapter);
    }

    @Override
    protected void exePageRequest(int pageNum) {
        presenter.requestTestList(pageNum, this);
    }

}