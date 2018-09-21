package edu.utn.listenchat.activity;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.utn.listenchat.R;
import edu.utn.listenchat.db.MessageContract;

public class CustomListAdapter extends CursorAdapter {

    public CustomListAdapter(Context context, Cursor c) {
        super(context, c, true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String name = cursor.getString(cursor.getColumnIndex(MessageContract.MessageEntry.COLUMN_NAME_CONTACT));
        String message = cursor.getString(cursor.getColumnIndex(MessageContract.MessageEntry.COLUMN_NAME_CONTENT));

        TextView txtTitle = (TextView) view.findViewById(R.id.Item_name);
        txtTitle.setText(name);

        TextView textMessage = (TextView) view.findViewById(R.id.Item_subject);
        textMessage.setText(message);
    }

}