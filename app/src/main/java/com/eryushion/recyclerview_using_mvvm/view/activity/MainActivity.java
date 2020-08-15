package com.eryushion.recyclerview_using_mvvm.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.eryushion.recyclerview_using_mvvm.R;
import com.eryushion.recyclerview_using_mvvm.databinding.ActivityMainBinding;
import com.eryushion.recyclerview_using_mvvm.model.DataModel;
import com.eryushion.recyclerview_using_mvvm.view.adapter.DataAdapter;
import com.eryushion.recyclerview_using_mvvm.view_model.DataViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        DataViewModel dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.init();

        final DataAdapter dataAdapter = new DataAdapter(dataViewModel.getData().getValue());

        dataViewModel.getData().observe(this, new Observer<List<DataModel>>() {
            @Override
            public void onChanged(List<DataModel> dataModels) {
                dataAdapter.notifyDataSetChanged();
            }
        });

        activityMainBinding.rvData.setAdapter(dataAdapter);

    }
}