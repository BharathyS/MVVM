package com.cumulation.mvvmarchitecture.datamodel.remote;

import com.cumulation.mvvmarchitecture.datamodel.remote.model.Name;
import io.reactivex.Observable;
import retrofit2.http.GET;

import java.util.ArrayList;

public interface ApiService
{
    @GET
    Observable<ArrayList<Name>>  getNames();
}
