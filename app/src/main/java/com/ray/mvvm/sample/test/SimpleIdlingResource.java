package com.ray.mvvm.sample.test;

import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Android Studio.
 * ProjectName: AndroidMVVM
 * Author:  Rayman
 * Date: 15/02/2017
 * Time: 5:11 PM
 * \ --------------------------------------------
 * \| The only thing that is constant is change!  |
 * \ --------------------------------------------
 * \  \
 * \   \   \_\_    _/_/
 * \    \      \__/
 * \           (oo)\_______
 * \           (__)\       )\/\
 * \               ||----w |
 * \               ||     ||
 */
public class SimpleIdlingResource implements IdlingResource {

    private final AtomicBoolean idleNow;

    private ResourceCallback callback;

    public SimpleIdlingResource(boolean idleNow) {
        this.idleNow = new AtomicBoolean(idleNow);
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return idleNow.get();
    }

    public void setIdleNow(boolean idleNow) {
        this.idleNow.set(idleNow);
        if (idleNow && callback != null) {
            callback.onTransitionToIdle();
        }
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.callback = callback;
    }
}
