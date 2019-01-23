package com.cumulation.mvvmarchitecture.datamodel.local;

import com.cumulation.mvvmarchitecture.datamodel.DataSource;
import com.cumulation.mvvmarchitecture.datamodel.local.entity.NameEntity;
import com.cumulation.mvvmarchitecture.datamodel.remote.model.Name;
import com.cumulation.mvvmarchitecture.util.AppExecutors;

import java.util.ArrayList;
import java.util.List;

public class LocalDataSource implements DataSource {

    private static LocalDataSource INSTANCE;
    private AppExecutors appExecutors;
    private AppDao appDao;

    private LocalDataSource(AppExecutors appExecutors, AppDao appDao) {
        this.appExecutors = appExecutors;
        this.appDao = appDao;
    }

    static public LocalDataSource getInstance(AppExecutors appExecutors, AppDao appDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(appExecutors, appDao);
        }
        return INSTANCE;
    }

    @Override
    public void getNames(final OnGetNameCallBack callBack) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<NameEntity> nameEntities = appDao.getNames();
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onNamesReceived(new ArrayList<Name>());
                    }
                });
            }
        };
        appExecutors.diskIO().execute(runnable);
    }
}
