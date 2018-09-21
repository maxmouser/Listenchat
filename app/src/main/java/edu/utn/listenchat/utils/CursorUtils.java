package edu.utn.listenchat.utils;

import android.database.Cursor;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.util.List;

public class CursorUtils {

    private CursorUtils() {

    }

    public static Multimap<String, String> convertCursorToMap(Cursor cursor) {
        Multimap<String, String> map = ArrayListMultimap.create();
        if (cursor.moveToFirst()) {
            do {
                String contact = cursor.getString(2);
                String message = cursor.getString(3);
                map.put(contact, message);
            } while(cursor.moveToNext());
        }
        return map;
    }

    public static List<Integer> messageIds(Cursor cursor) {
        List<Integer> ids = Lists.newArrayList();

        if (cursor.moveToFirst()) {
            do {
                ids.add(cursor.getInt(0));
            } while(cursor.moveToNext());
        }
        return ids;
    }
}
