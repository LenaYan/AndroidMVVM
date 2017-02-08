package com.ray.mvvm.sample.view.simple.vm;

import android.databinding.Bindable;
import android.text.TextUtils;
import android.view.View;

import com.ray.mvvm.lib.BR;
import com.ray.mvvm.lib.model.http.ExSubscriber;
import com.ray.mvvm.lib.model.model.RespEntity;
import com.ray.mvvm.lib.viewmodel.BaseVM;
import com.ray.mvvm.sample.R;
import com.ray.mvvm.sample.view.simple.contract.SimplePageContract;

public final class SimplePageVM extends BaseVM<SimplePageContract.Presenter, SimplePageContract.View> {

    private String input;
    private boolean enableUpperCase = true;
    private boolean hintAnimEnabled = false;

    public SimplePageVM(SimplePageContract.Presenter presenter, SimplePageContract.View view) {
        super(presenter, view);
        view.delayToResume(() -> setHintAnimEnabled(true));
    }

    private boolean inputCheck() {
        if (TextUtils.isEmpty(input)) {
            this.view.showToast(R.string.input_null_checking);
            return false;
        }
        return true;
    }

    public void onToUpperCase(View view) {
        if (!inputCheck())
            return;
        setInput(input.toUpperCase());
    }

    public void onSubmiteClicked(View view) {
        if (!inputCheck())
            return;
        presenter.submiteData(input, new ExSubscriber<RespEntity>() {
            @Override
            public void onStart() {
                super.onStart();
                SimplePageVM.this.view.showProgressDialog();
            }

            @Override
            public void onError(Throwable e) {
                SimplePageVM.this.view.hideProgressDialog();
                SimplePageVM.this.view.showToast(e.getMessage());
            }

            @Override
            public void onNext(RespEntity respEntity) {
                SimplePageVM.this.view.hideProgressDialog();
                SimplePageVM.this.view.showToast(R.string.submite_successfully);
                setInput(null);
            }
        });
    }

    @Bindable
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        if (TextUtils.equals(input, this.input))
            return;
        this.input = input;
        notifyPropertyChanged(BR.input);
    }

    @Bindable
    public boolean isEnableUpperCase() {
        return enableUpperCase;
    }

    public void setEnableUpperCase(boolean enableUpperCase) {
        if (enableUpperCase == this.enableUpperCase)
            return;
        this.enableUpperCase = enableUpperCase;
        notifyPropertyChanged(BR.enableUpperCase);
    }

    @Bindable
    public boolean isHintAnimEnabled() {
        return hintAnimEnabled;
    }

    private void setHintAnimEnabled(boolean hintAnimEnabled) {
        if (hintAnimEnabled == this.hintAnimEnabled)
            return;
        this.hintAnimEnabled = hintAnimEnabled;
        notifyPropertyChanged(BR.hintAnimEnabled);
    }
}
