package com.ray.mvvm.sample.view.common.vm;

import android.support.v7.widget.RecyclerView;

import com.ray.mvvm.lib.view.adapter.OnItemClick;
import com.ray.mvvm.lib.view.adapter.list.base.CellVM;
import com.ray.mvvm.sample.model.model.TestEntity;

/**
 * Created by Android Studio.
 * ProjectName: AndroidMVVM
 * Author:  Lena
 * Date: 31/01/2017
 * Time: 8:53 PM
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
public class TestCellVM extends CellVM<TestEntity> {

    public TestCellVM(TestEntity data, RecyclerView.ViewHolder viewHolder, OnItemClick<TestEntity> itemClick) {
        super(data, viewHolder, itemClick);
    }

}
