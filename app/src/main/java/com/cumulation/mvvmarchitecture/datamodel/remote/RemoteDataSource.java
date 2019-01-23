package com.cumulation.mvvmarchitecture.datamodel.remote;

import android.os.Handler;
import com.cumulation.mvvmarchitecture.datamodel.DataSource;
import com.cumulation.mvvmarchitecture.datamodel.remote.model.Name;

import java.util.ArrayList;

public class RemoteDataSource implements DataSource {

    private static RemoteDataSource INSTANCE;
    private ApiService apiService;

    private RemoteDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    public static RemoteDataSource getInstance(ApiService apiService) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(apiService);
        }
        return INSTANCE;
    }

    @Override
    public void getNames(final OnGetNameCallBack callBack) {
        /*Disposable sub = apiService.getNames()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<Name>>() {
                    @Override
                    public void accept(ArrayList<Name> names) {
                        callBack.onNamesReceived(names);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        callBack.onError(throwable.getMessage());
                    }
                });*/
        final ArrayList<Name> names = new ArrayList<>();
        names.add(new Name("a" + System.currentTimeMillis()));
        names.add(new Name("b" + System.currentTimeMillis()));
        names.add(new Name("c" + System.currentTimeMillis()));
        names.add(new Name("d" + System.currentTimeMillis()));
        names.add(new Name("e" + System.currentTimeMillis()));
        names.add(new Name("f" + System.currentTimeMillis()));
        names.add(new Name("g" + System.currentTimeMillis()));
        names.add(new Name("h" + System.currentTimeMillis()));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callBack.onNamesReceived(names);
            }
        }, 5000);
    }
}
