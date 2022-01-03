package com.example.companyproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class StudentDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="student.db";

    public static final String CREATE_STUDENT="CREATE_TABLE"+StudentDbContract.StuTable.TABLE_NAME+"("+StudentDbContract
            .StuTable._ID+"TEXT,"+StudentDbContract.StuTable.COLUMN_AGE+"TEXT)";

    public static final String DELETE_STUDENT=
            "DROP TABLE IF EXISTS"+StudentDbContract.StuTable.TABLE_NAME;

    public StudentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT);
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_STUDENT);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
