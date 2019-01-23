package com.cumulation.mvvmarchitecture.util;

import android.content.Context;
import com.cumulation.mvvmarchitecture.datamodel.Repository;
import com.cumulation.mvvmarchitecture.datamodel.local.AppDataBase;
import com.cumulation.mvvmarchitecture.datamodel.local.LocalDataSource;
import com.cumulation.mvvmarchitecture.datamodel.remote.RemoteDataSource;
import com.cumulation.mvvmarchitecture.datamodel.remote.RestClient;

public class Injection {
    public static Repository getRepository(Context context) {
        AppDataBase appDataBase = AppDataBase.getInstance(context);
        Repository repository = Repository.getInstance(LocalDataSource.getInstance(new AppExecutors(), appDataBase.appDao())
                , RemoteDataSource.getInstance(RestClient.getApiservice()));
        return repository;
    }
}
