package com.example.companyproject;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentContentProvider extends ContentProvider {


    public static final int STUDENT=100;
    public static final int STUDENT_ID=101;

    public static final String AUTHORITY_NAME="com.example.companyproject";
    public static final Uri STUDENT_URI=Uri.parse("content://"+AUTHORITY_NAME+"/"+ StudentDbContract.StuTable.TABLE_NAME);
    public static final Uri STUDENT_URI_ID=Uri.parse("content://"+AUTHORITY_NAME+"/"+ StudentDbContract.StuTable.TABLE_NAME+"/"+STUDENT_ID);

    private StudentDbHelper stuHelper;
    public static final UriMatcher strUriMatcher = buidUriMatcher();

    private static UriMatcher buidUriMatcher(){
        final UriMatcher matcher =new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITY_NAME, StudentDbContract.StuTable.TABLE_NAME,STUDENT);
        matcher.addURI(AUTHORITY_NAME, StudentDbContract.StuTable.TABLE_NAME+"/*",STUDENT_ID);


        return matcher;
    }



    @Override
    public boolean onCreate() {
        Context context =getContext();
        stuHelper=new StudentDbHelper(context);
        return true;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,String sortOrder) {
        return null;
    }


    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri,ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri,String selection,String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update( Uri uri,  ContentValues values,String selection,String[] selectionArgs) {
        return 0;
    }
}
