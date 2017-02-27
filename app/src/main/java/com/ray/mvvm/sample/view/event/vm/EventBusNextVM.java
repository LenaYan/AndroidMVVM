/*
 * Copyright (C) 2015 Rayman Yan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ray.mvvm.sample.view.event.vm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ray.mvvm.sample.BR;
import com.ray.mvvm.sample.model.model.sample.TestEntity;

/**
 * Created by Android Studio.
 * ProjectName: AndroidMVVM
 * Author:  Rayman
 * Date: 27/02/2017
 * Time: 3:00 PM
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
public final class EventBusNextVM extends BaseObservable {

    private TestEntity data;

    public EventBusNextVM() {
    }

    @Bindable
    public TestEntity getData() {
        return data;
    }

    public void setData(TestEntity data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
    }
}
