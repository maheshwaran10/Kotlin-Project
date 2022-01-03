package com.example.companyproject;

import android.provider.BaseColumns;

public class StudentDbContract {

    private StudentDbContract(){

    }
    public static class StuTable implements BaseColumns{
        public static final String TABLE_NAME="student";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_AGE="age";
    }

}
