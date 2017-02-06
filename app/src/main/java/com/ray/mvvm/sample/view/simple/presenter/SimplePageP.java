package com.ray.mvvm.sample.view.simple.presenter;

import com.ray.mvvm.lib.model.model.GenericRespEntity;
import com.ray.mvvm.lib.model.model.RespEntity;
import com.ray.mvvm.lib.presenter.GenericPresenter;
import com.ray.mvvm.sample.view.simple.contract.SimplePageContract;

import javax.inject.Inject;

import rx.Subscriber;

public final class SimplePageP extends GenericPresenter implements SimplePageContract.Presenter {

    @Inject
    SimplePageP() {
    }

    @Override
    public void submiteData(String input, Subscriber<RespEntity> subscriber) {
        mockResp(new GenericRespEntity<>(RespEntity.SUCCESS))
                .compose(applyAsyncGenericVoid())
                .subscribe(subscriber);
    }
}
