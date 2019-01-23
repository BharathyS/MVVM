package com.cumulation.mvvmarchitecture.datamodel;

import com.cumulation.mvvmarchitecture.datamodel.local.LocalDataSource;
import com.cumulation.mvvmarchitecture.datamodel.remote.RemoteDataSource;

public class Repository implements DataSource {

    static private Repository INSTANCE;
    private RemoteDataSource remoteDataSource;
    private LocalDataSource localDataSource;

    private Repository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static Repository getInstance(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(localDataSource, remoteDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getNames(OnGetNameCallBack callBack) {
        remoteDataSource.getNames(callBack);
    }
}
