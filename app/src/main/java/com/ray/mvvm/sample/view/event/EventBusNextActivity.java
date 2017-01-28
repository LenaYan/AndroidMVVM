package com.ray.mvvm.sample.view.event;

import android.os.Bundle;
import android.view.View;

import com.ray.mvvm.lib.view.base.page.BaseActivity;
import com.ray.mvvm.lib.view.base.view.IRedirect;
import com.ray.mvvm.lib.widget.eventbus.RxBus;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.TestEvent;
import com.ray.mvvm.sample.model.model.TestEntity;

public class EventBusNextActivity extends BaseActivity {

    public static void start(IRedirect redirect) {
        redirect.intent(EventBusNextActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_next);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onSendEventClicked(View view) {
        RxBus.instance().post(new TestEvent(new TestEntity("Sent from next page", "Event sent from another page, will received after resumed", System.currentTimeMillis())));
        showToast(R.string.event_sent);
    }

}
