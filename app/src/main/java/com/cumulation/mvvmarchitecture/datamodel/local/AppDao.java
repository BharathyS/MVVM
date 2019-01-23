package com.cumulation.mvvmarchitecture.datamodel.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.cumulation.mvvmarchitecture.datamodel.local.entity.NameEntity;

import java.util.List;

@Dao
public interface AppDao
{
    @Insert
    void addName(NameEntity nameEntity);

    @Query("Select * from " + AppDataBase.TABLE.NAME_TABLE)
    List<NameEntity> getNames();
}
