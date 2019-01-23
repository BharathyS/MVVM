package com.cumulation.mvvmarchitecture.datamodel.local;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.*;
import android.content.Context;
import android.support.annotation.NonNull;
import com.cumulation.mvvmarchitecture.datamodel.local.entity.NameEntity;

@Database(entities = {NameEntity.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase INSTANCE;
    private final static String DATABASE_NAME="appdatabase.db";

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,DATABASE_NAME).build();
        }
        return INSTANCE;
    }

    public abstract AppDao appDao();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }

    public static class TABLE {
        final static public String NAME_TABLE = "name_table";
    }
}
