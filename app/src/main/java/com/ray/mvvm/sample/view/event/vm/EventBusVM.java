package com.ray.mvvm.sample.view.event.vm;

import android.databinding.Bindable;
import android.view.View;

import com.ray.mvvm.lib.viewmodel.BaseVM;
import com.ray.mvvm.lib.widget.eventbus.RxBus;
import com.ray.mvvm.sample.BR;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.TestEvent;
import com.ray.mvvm.sample.model.model.TestEntity;
import com.ray.mvvm.sample.view.event.EventBusNextActivity;
import com.ray.mvvm.sample.view.event.contract.EventBusContract;

public class EventBusVM extends BaseVM<EventBusContract.Presenter, EventBusContract.View> {

    private TestEntity entity;

    public EventBusVM(EventBusContract.Presenter presenter, EventBusContract.View view) {
        super(presenter, view);
        view.subscribeEvent(TestEvent.class, testEvent -> {
            setEntity(testEvent.getEntity());
        });
    }

    @Bindable
    public TestEntity getEntity() {
        return entity;
    }

    private void setEntity(TestEntity entity) {
        this.entity = entity;
        EventBusVM.this.view.showToast(R.string.event_received);
        notifyPropertyChanged(BR.entity);
    }

    public void onSendEventClicked(View view) {
        RxBus.instance().post(new TestEvent(new TestEntity("Sent from thread " + Thread.currentThread().getId(), "Event from local sender", System.currentTimeMillis())));
    }

    public void onSendEventFromDiffThreadClicked(View view) {
        presenter.sendEvent();
    }

    public void onStartNextPageClicked(View view) {
        EventBusNextActivity.start(this.view);
    }
}
