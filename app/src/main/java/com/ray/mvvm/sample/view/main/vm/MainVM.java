package com.ray.mvvm.sample.view.main.vm;

import android.support.v7.widget.RecyclerView;

import com.ray.mvvm.lib.view.adapter.list.base.ListAdapter;
import com.ray.mvvm.lib.viewmodel.ListVM;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.model.model.sample.SampleEntity;
import com.ray.mvvm.sample.view.event.EventBusActivity;
import com.ray.mvvm.sample.view.list.SimpleListActivity;
import com.ray.mvvm.sample.view.list.TestListActivity;
import com.ray.mvvm.sample.view.main.contract.MainContract;
import com.ray.mvvm.sample.view.simple.SimpleDataPageActivity;
import com.ray.mvvm.sample.view.simple.SimplePageActivity;

import java.util.ArrayList;
import java.util.List;

public final class MainVM extends ListVM<MainContract.Presenter, MainContract.View, SampleEntity> {

    public MainVM(MainContract.Presenter presenter, MainContract.View view, RecyclerView.LayoutManager layoutManager, ListAdapter<SampleEntity> adapter) {
        super(presenter, view, layoutManager, adapter);
    }

    public void init() {
        List<SampleEntity> sampleEntities = new ArrayList<>();
        sampleEntities.add(new SampleEntity(view.findString(R.string.title_activity_simple_page), (position, view1, sampleEntity) -> SimplePageActivity.start(view)));
        sampleEntities.add(new SampleEntity(view.findString(R.string.title_activity_simple_data_page), (position, view1, sampleEntity) -> SimpleDataPageActivity.start(view)));
        sampleEntities.add(new SampleEntity(view.findString(R.string.title_activity_event_bus), (position, view1, sampleEntity) -> EventBusActivity.start(view)));
        sampleEntities.add(new SampleEntity(view.findString(R.string.title_activity_simple_list), (position, view1, sampleEntity) -> SimpleListActivity.start(view)));
        sampleEntities.add(new SampleEntity(view.findString(R.string.title_activity_test_list), (position, view1, sampleEntity) -> TestListActivity.start(view)));
        onNext(sampleEntities);
    }

}
