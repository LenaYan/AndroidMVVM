package com.ray.mvvm.sample.view.list.presenter;

import com.ray.mvvm.lib.presenter.CommonPresenter;
import com.ray.mvvm.sample.model.model.TestEntity;
import com.ray.mvvm.sample.view.list.contract.SimpleListContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SimpleListP extends CommonPresenter implements SimpleListContract.Presenter {

    @Inject
    SimpleListP() {
    }

    @Override
    public List<TestEntity> mockList(int count) {
        List<TestEntity> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new TestEntity("Test " + i, "Des", System.nanoTime()));
        }
        return list;
    }

}
