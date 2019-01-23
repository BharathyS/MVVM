package com.cumulation.mvvmarchitecture.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import com.cumulation.mvvmarchitecture.datamodel.DataSource;
import com.cumulation.mvvmarchitecture.datamodel.Repository;
import com.cumulation.mvvmarchitecture.datamodel.remote.model.Name;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel implements DataSource.OnGetNameCallBack {

    private final Repository repository;
    private MutableLiveData<List<Name>> names;

    public HomeViewModel(Application context, Repository repository) {
        super(context);
        this.repository = repository;
        names = new MutableLiveData<>();
    }

    @Override
    public void onNamesReceived(ArrayList<Name> names) {
        this.names.postValue(names);
    }

    @Override
    public void onError(String errorMessage) {

    }

    public MutableLiveData<List<Name>> getNames() {
        return names;
    }

    public void start() {
        repository.getNames(this);
    }
}
