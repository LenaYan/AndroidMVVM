package com.ray.mvvm.sample.view.main.vm;

import android.support.v7.widget.RecyclerView;

import com.ray.mvvm.lib.view.adapter.list.base.ListAdapter;
import com.ray.mvvm.lib.viewmodel.ListVM;
import com.ray.mvvm.lib.widget.lifecycle.LifecycleEvent;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.model.model.SampleEntity;
import com.ray.mvvm.sample.view.event.EventBusActivity;
import com.ray.mvvm.sample.view.list.SimpleListActivity;
import com.ray.mvvm.sample.view.list.TestListActivity;
import com.ray.mvvm.sample.view.main.contract.MainContract;
import com.ray.mvvm.sample.view.simple.SimpleDataPageActivity;
import com.ray.mvvm.sample.view.simple.SimplePageActivity;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import rx.subjects.PublishSubject;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

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

    public void requestPermission(RxPermissions rxPermissions) {
        PublishSubject<Boolean> subject = PublishSubject.create();
        subject
                .compose(rxPermissions
                        .ensure(WRITE_EXTERNAL_STORAGE,
                                READ_EXTERNAL_STORAGE))
                .compose(view.bindUntilEvent(LifecycleEvent.DESTROY))
                .subscribe(granted -> {
                    if (granted) {
                        subject.onCompleted();
                    } else {
                        view.showPermissionDialog(subject);
                    }
                });
        subject.onNext(true);
    }

}
