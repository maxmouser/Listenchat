package edu.utn.listenchat.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static edu.utn.listenchat.db.MessageContract.MessageEntry.COLUMN_NAME_CONTACT;
import static edu.utn.listenchat.db.MessageContract.MessageEntry.COLUMN_NAME_CONTENT;
import static edu.utn.listenchat.db.MessageContract.MessageEntry.COLUMN_NAME_DATE;
import static edu.utn.listenchat.db.MessageContract.MessageEntry.COLUMN_NAME_INTENT_ID;
import static edu.utn.listenchat.db.MessageContract.MessageEntry.COLUMN_NAME_LEIDO;
import static edu.utn.listenchat.db.MessageContract.MessageEntry.TABLE_NAME;

public class ListenchatDbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME +
            " (" + _ID + " INTEGER PRIMARY KEY," +
            COLUMN_NAME_INTENT_ID + TEXT_TYPE + COMMA_SEP +
            COLUMN_NAME_CONTACT + TEXT_TYPE + COMMA_SEP +
            COLUMN_NAME_CONTENT + TEXT_TYPE + COMMA_SEP +
            COLUMN_NAME_LEIDO + TEXT_TYPE + COMMA_SEP +
            COLUMN_NAME_DATE + TEXT_TYPE + " )";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Listenchat.db";

    public ListenchatDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}