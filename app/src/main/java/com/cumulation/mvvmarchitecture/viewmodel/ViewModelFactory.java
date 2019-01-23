package com.cumulation.mvvmarchitecture.viewmodel;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import com.cumulation.mvvmarchitecture.datamodel.Repository;
import com.cumulation.mvvmarchitecture.util.Injection;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static ViewModelFactory INSTANCE;
    private Repository repository;
    private Application application;

    private ViewModelFactory(Application application, Repository repository) {
        this.application = application;
        this.repository = repository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            INSTANCE = new ViewModelFactory(application, Injection.getRepository(application));
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            //noinspection unchecked
            return (T) new HomeViewModel(application, repository);
        }
        return super.create(modelClass);
    }
}
