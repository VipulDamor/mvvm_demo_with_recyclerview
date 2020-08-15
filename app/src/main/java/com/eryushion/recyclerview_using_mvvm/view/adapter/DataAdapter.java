package com.eryushion.recyclerview_using_mvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eryushion.recyclerview_using_mvvm.R;
import com.eryushion.recyclerview_using_mvvm.databinding.RawDataBinding;
import com.eryushion.recyclerview_using_mvvm.model.DataModel;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewholder> {

    private LayoutInflater layoutInflater;
    private List<DataModel> value;

    public DataAdapter(List<DataModel> value) {
        this.value = value;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        RawDataBinding rawDataBinding = RawDataBinding.inflate(layoutInflater, parent, false);
        return new MyViewholder(rawDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        DataModel dataModel = value.get(holder.getAdapterPosition());
        holder.bind(dataModel);

    }

    @Override
    public int getItemCount() {
        return value.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {

        RawDataBinding rawDataBinding;

        public MyViewholder(RawDataBinding rawDataBinding) {
            super(rawDataBinding.getRoot());
            this.rawDataBinding = rawDataBinding;
        }

        public void bind(DataModel dataModel) {
            rawDataBinding.setRawdata(dataModel);
            rawDataBinding.executePendingBindings();
        }
    }
}
