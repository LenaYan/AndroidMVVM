package com.ray.mvvm.sample.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ray.mvvm.lib.view.adapter.list.base.StateListAdapter;
import com.ray.mvvm.sample.databinding.ListCellTestBinding;
import com.ray.mvvm.sample.model.model.TestEntity;
import com.ray.mvvm.sample.view.common.TestCellView;
import com.ray.mvvm.sample.view.common.vm.TestCellVM;

/**
 * Created by Android Studio.
 * ProjectName: AndroidMVVM
 * Author:  Lena
 * Date: 31/01/2017
 * Time: 8:48 PM
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
public class TestListAdapter extends StateListAdapter<TestEntity> {

    private final TestCellView cellView;

    public TestListAdapter(TestCellView cellView) {
        this.cellView = cellView;
    }

    @Override
    protected ViewDataBinding createBinding(LayoutInflater layoutInflater, ViewGroup parent, int viewType) {
        return ListCellTestBinding.inflate(layoutInflater, parent, false);
    }

    @Override
    protected Object createViewModel(RecyclerView.ViewHolder holder, int position) {
        return new TestCellVM(getItem(position), holder, cellView);
    }

}
