package com.ray.mvvm.sample.view.simple.presenter;

import com.ray.mvvm.lib.model.http.ExObserver;
import com.ray.mvvm.lib.presenter.CommonPresenter;
import com.ray.mvvm.sample.model.model.sample.TestEntity;
import com.ray.mvvm.sample.view.simple.contract.SimpleDataPageContract;

import javax.inject.Inject;

public class SimpleDataPageP extends CommonPresenter implements SimpleDataPageContract.Presenter {

    @Inject
    SimpleDataPageP() {
    }

    @Override
    public void requstData(ExObserver<TestEntity> observer) {
        mockResp(() -> new TestEntity("Title(from server)", "Des(from server)", System.currentTimeMillis()))
                .compose(applyAsync(observer))
                .subscribe(observer);
    }

}
