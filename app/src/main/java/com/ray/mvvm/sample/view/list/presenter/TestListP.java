package com.ray.mvvm.sample.view.list.presenter;

import com.ray.mvvm.lib.model.http.ExObserver;
import com.ray.mvvm.lib.model.model.ListRespEntity;
import com.ray.mvvm.lib.presenter.CommonPresenter;
import com.ray.mvvm.sample.model.model.sample.TestEntity;
import com.ray.mvvm.sample.view.list.contract.TestListContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TestListP extends CommonPresenter implements TestListContract.Presenter {

    private int index = 0;

    @Inject
    TestListP() {
    }

    @Override
    public void requestTestList(int page, ExObserver<ListRespEntity<TestEntity>> observer) {
        mockResp(
                () -> {
                    List<TestEntity> testEntities = new ArrayList<>();
                    ListRespEntity<TestEntity> respEntity = new ListRespEntity<>();
                    if (page == 1)
                        index = 0;
                    if (page <= 2) {
                        for (int i = 0; i < 20; i++) {
                            TestEntity testEntity = new TestEntity("Name " + index, "Description", System.nanoTime());
                            testEntities.add(testEntity);
                            index += 1;
                        }
                        respEntity.setHasMore(true);
                    }
                    respEntity.setList(testEntities);
                    return respEntity;
                })
                .compose(applyAsync(observer))
                .subscribe(observer);
    }
}
