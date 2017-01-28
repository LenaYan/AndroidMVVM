package com.ray.mvvm.sample.view.event.presenter;

import com.ray.mvvm.lib.presenter.CommonPresenter;
import com.ray.mvvm.lib.widget.eventbus.RxBus;
import com.ray.mvvm.sample.TestEvent;
import com.ray.mvvm.sample.model.model.TestEntity;
import com.ray.mvvm.sample.view.event.contract.EventBusContract;

import javax.inject.Inject;

import rx.Observable;

public class EventBusP extends CommonPresenter implements EventBusContract.Presenter {

    @Inject
    EventBusP() {
    }

    @Override
    public void sendEvent() {
        Observable.just(true)
                .map(result -> {
                    RxBus.instance().post(new TestEvent(new TestEntity("Sent from thread" + Thread.currentThread().getId(), "Event from another thread.", System.currentTimeMillis())));
                    return result;
                })
                .compose(commonObservableTransformer())
                .subscribe();
    }
}
