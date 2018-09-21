package edu.utn.listenchat.db;

import android.content.Context;
import android.database.Cursor;

import java.util.List;

import edu.utn.listenchat.model.Message;
import edu.utn.listenchat.service.PersistenceService;

import static com.google.common.collect.Lists.newArrayList;
import static edu.utn.listenchat.utils.DateUtils.toDate;
import static edu.utn.listenchat.utils.StringUtils.safeEquals;

/**
 * Created by fabian on 9/10/17.
 */

public class MessageDao {

    private PersistenceService persistenceService = new PersistenceService();


    public List<Message> all(Context context) {
        Cursor cursor = this.persistenceService.getAllCursor(context);
        List<Message> messages = newArrayList();

        if (cursor.moveToFirst()) {
            do {
                Message message = new Message();

                message.setIntentId(cursor.getString(1));
                message.setName(cursor.getString(2));
                message.setMessage(cursor.getString(3));
                message.setLeido(cursor.getString(4));
                message.setReceivedDate(toDate(cursor.getString(5)));

                messages.add(message);
            } while(cursor.moveToNext());
        }
        return messages;
    }

    public List<Message> allFromContact(Context context, String contact) {
        List<Message> allFromContact = newArrayList();

        for (Message message : this.all(context)) {
            if (safeEquals(contact, message.getName())) {
                allFromContact.add(message);
            }
        }
        return allFromContact;
    }

}
