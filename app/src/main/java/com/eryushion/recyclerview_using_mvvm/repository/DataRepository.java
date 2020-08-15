package com.eryushion.recyclerview_using_mvvm.repository;

import androidx.lifecycle.MutableLiveData;

import com.eryushion.recyclerview_using_mvvm.model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    private static DataRepository instance;
    private List<DataModel> dataModelList = new ArrayList<>();

    public static DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }
    public MutableLiveData<List<DataModel>> getData() {
        setdata();
        MutableLiveData<List<DataModel>> data = new MutableLiveData<>();
        data.setValue(dataModelList);
        return data;
    }

    private void setdata() {
        for (int i = 0; i < 10; i++) {
            dataModelList.add(new DataModel("Test" + i));
        }
    }
}
