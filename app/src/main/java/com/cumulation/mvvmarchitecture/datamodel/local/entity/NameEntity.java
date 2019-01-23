package com.cumulation.mvvmarchitecture.datamodel.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import com.cumulation.mvvmarchitecture.datamodel.local.AppDataBase;

@Entity(tableName = AppDataBase.TABLE.NAME_TABLE)
public class NameEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
