package com.ray.mvvm.sample.view.event;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.ray.mvvm.lib.view.base.page.BaseActivity;
import com.ray.mvvm.lib.view.base.view.IRedirect;
import com.ray.mvvm.lib.widget.eventbus.RxBus;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.TestEvent;
import com.ray.mvvm.sample.databinding.ActivityEventBusNextBinding;
import com.ray.mvvm.sample.model.model.sample.TestEntity;
import com.ray.mvvm.sample.view.event.vm.EventBusNextVM;

public class EventBusNextActivity extends BaseActivity {

    private EventBusNextVM viewModel;

    public static void start(IRedirect redirect) {
        redirect.intent(EventBusNextActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEventBusNextBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_event_bus_next);
        viewModel = new EventBusNextVM();
        binding.setViewModel(viewModel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onSendEventClicked(View view) {
        TestEntity entity = new TestEntity("Sent from next page", "Event sent from another page, will received after resumed", System.currentTimeMillis());
        RxBus.instance().post(new TestEvent(entity));
        viewModel.setData(entity);
        showToast(R.string.event_sent);
    }
}
