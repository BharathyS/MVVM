package com.cumulation.mvvmarchitecture.datamodel.remote;

import retrofit2.Retrofit;

public class RestClient
{
    private static RestClient INSTANCE;

    private RestClient(){

    }

    public static ApiService getApiservice(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();
        return retrofit.create(ApiService.class);
    }

}
