package com.cumulation.mvvmarchitecture.datamodel;

import com.cumulation.mvvmarchitecture.datamodel.remote.model.Name;

import java.util.ArrayList;

public interface DataSource {
    interface OnGetNameCallBack {
        void onNamesReceived(ArrayList<Name> name);

        void onError(String errorMessage);
    }

    void getNames(OnGetNameCallBack callBack);
}
