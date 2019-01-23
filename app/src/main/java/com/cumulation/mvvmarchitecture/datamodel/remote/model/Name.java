package com.cumulation.mvvmarchitecture.datamodel.remote.model;

public class Name
{
    public Name(String name){
        this.name=name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
