package edu.utn.listenchat.db;

import android.provider.BaseColumns;

public final class MessageContract {

    private MessageContract() {}

    /* Inner class that defines the table contents */
    public static class MessageEntry implements BaseColumns {
        public static final String TABLE_NAME = "message";
        public static final String COLUMN_NAME_CONTACT = "contact";
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_LEIDO = "leido";
        public static final String COLUMN_NAME_INTENT_ID = "intent_id";
    }



}
