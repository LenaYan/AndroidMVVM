package com.ray.mvvm.sample.view.main.vm;

import android.support.v7.widget.RecyclerView;

import com.ray.mvvm.lib.view.adapter.OnItemClick;
import com.ray.mvvm.lib.view.adapter.list.base.CellVM;
import com.ray.mvvm.sample.model.model.SampleEntity;

/**
 * Created by Android Studio.
 * ProjectName: AndroidMVVM
 * Author:  Lena
 * Date: 27/01/2017
 * Time: 7:53 PM
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
public class SampleCellVM extends CellVM<SampleEntity> {

    public SampleCellVM(SampleEntity data, RecyclerView.ViewHolder viewHolder, OnItemClick<SampleEntity> itemClick) {
        super(data, viewHolder, itemClick);
    }
}
