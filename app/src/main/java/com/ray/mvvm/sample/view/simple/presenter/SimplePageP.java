package com.ray.mvvm.sample.view.simple.presenter;

import com.ray.mvvm.lib.presenter.CommonPresenter;
import com.ray.mvvm.sample.view.simple.contract.SimplePageContract;

import javax.inject.Inject;

public final class SimplePageP extends CommonPresenter implements SimplePageContract.Presenter {

    @Inject
    SimplePageP() {
    }

}
