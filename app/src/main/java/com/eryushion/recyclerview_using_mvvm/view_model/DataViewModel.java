package com.eryushion.recyclerview_using_mvvm.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eryushion.recyclerview_using_mvvm.model.DataModel;
import com.eryushion.recyclerview_using_mvvm.repository.DataRepository;

import java.util.List;

public class DataViewModel extends ViewModel {

    private MutableLiveData<List<DataModel>> liveData;

    public void init() {
        if (liveData != null)
            return;
        DataRepository dataRepository = DataRepository.getInstance();
        liveData = dataRepository.getData();

    }

    public LiveData<List<DataModel>> getData() {
        return liveData;
    }
}
