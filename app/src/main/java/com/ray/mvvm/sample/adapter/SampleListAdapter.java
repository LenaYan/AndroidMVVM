package com.ray.mvvm.sample.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ray.mvvm.lib.view.adapter.list.base.ListAdapter;
import com.ray.mvvm.sample.databinding.ListCellSampleBinding;
import com.ray.mvvm.sample.model.model.SampleEntity;
import com.ray.mvvm.sample.view.main.contract.MainContract;
import com.ray.mvvm.sample.view.main.vm.SampleCellVM;

/**
 * Created by Android Studio.
 * ProjectName: AndroidMVVM
 * Author:  Lena
 * Date: 27/01/2017
 * Time: 7:43 PM
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
public class SampleListAdapter extends ListAdapter<SampleEntity> {

    private MainContract.SampleCellView sampleCellView;

    public SampleListAdapter(MainContract.SampleCellView sampleCellView) {
        this.sampleCellView = sampleCellView;
    }

    @Override
    protected ViewDataBinding createBinding(LayoutInflater layoutInflater, ViewGroup parent, int viewType) {
        return ListCellSampleBinding.inflate(layoutInflater, parent, false);
    }

    @Override
    protected Object createViewModel(RecyclerView.ViewHolder holder, int position) {
        return new SampleCellVM(getItem(position), holder, sampleCellView);
    }
}
