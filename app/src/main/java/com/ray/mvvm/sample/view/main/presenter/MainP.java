package com.ray.mvvm.sample.view.main.presenter;

import com.ray.mvvm.lib.presenter.CommonPresenter;
import com.ray.mvvm.sample.view.main.contract.MainContract;

import javax.inject.Inject;

public final class MainP extends CommonPresenter implements MainContract.Presenter {

    @Inject
    MainP() {
    }

}
