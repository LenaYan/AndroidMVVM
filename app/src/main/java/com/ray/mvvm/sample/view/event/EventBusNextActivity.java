package com.ray.mvvm.sample.view.event;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.view.View;

import com.ray.mvvm.lib.view.base.page.BaseActivity;
import com.ray.mvvm.lib.view.base.view.IRedirect;
import com.ray.mvvm.lib.widget.eventbus.RxBus;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.TestEvent;
import com.ray.mvvm.sample.databinding.ActivityEventBusNextBinding;
import com.ray.mvvm.sample.model.model.sample.TestEntity;

public class EventBusNextActivity extends BaseActivity {

    private ObservableField<TestEntity> observableField = new ObservableField<>();

    public static void start(IRedirect redirect) {
        redirect.intent(EventBusNextActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEventBusNextBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_event_bus_next);
        binding.setTestEntity(observableField);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onSendEventClicked(View view) {
        TestEntity entity = new TestEntity("Sent from next page", "Event sent from another page, will received after resumed", System.currentTimeMillis());
        RxBus.instance().post(new TestEvent(entity));
        observableField.set(entity);
        showToast(R.string.event_sent);
    }
}
