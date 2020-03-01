package com.example.usermanagement;

import android.provider.BaseColumns;

public final class feedReaderContract {
    private feedReaderContract(){}
    public static class feedEntry implements BaseColumns {
        public static final String TABLE_NAME="user_management";
        public static final String  COLUMN_ID="id";
        public static final String COLUMN2 ="full_name";
        public static final String COLUMN3="user_name";
        public static final String COLUMN4="E_mail";
        public static final String COLUMN5="password";
        public static final String COLUMN6="mobile";






    }
}
