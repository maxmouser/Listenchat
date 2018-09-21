package edu.utn.listenchat.service;

import android.content.Context;

import com.google.common.collect.Lists;

import java.util.List;

import edu.utn.listenchat.model.Message;

import static edu.utn.listenchat.utils.DateUtils.toDate;

/**
 * Created by fabian on 9/11/17.
 */

public class DummyLoader {

    private PersistenceService persistenceService = new PersistenceService();

    public void load(Context context) {


        List<Message> messages = Lists.newArrayList();

        messages.add(Message.create("Cacho Garay", "Hola soy cacho 1", toDate("2017-09-05T00:11:22")));
        messages.add(Message.create("Cacho Garay", "Hola soy cacho 2", toDate("2017-09-05T00:11:22")));
        messages.add(Message.create("Cacho Garay", "Hola soy cacho 3", toDate("2017-09-05T00:11:22")));

        messages.add(Message.create("Cacho Garay", "Hola soy cacho 11", toDate("2017-09-06T00:11:22")));
        messages.add(Message.create("Cacho Garay", "Hola soy cacho 22", toDate("2017-09-06T00:11:22")));
        messages.add(Message.create("Cacho Garay", "Hola soy cacho 33", toDate("2017-09-06T00:11:22")));

        messages.add(Message.create("Cacho Garay", "Hola soy cacho 111", toDate("2017-09-07T00:11:22")));
        messages.add(Message.create("Cacho Garay", "Hola soy cacho 222", toDate("2017-09-07T00:11:22")));
        messages.add(Message.create("Cacho Garay", "Hola soy cacho 333", toDate("2017-09-07T00:11:22")));

        messages.add(Message.create("Sergio Gonal", "Hola soy sergio 1", toDate("2017-09-08T00:11:22")));
        messages.add(Message.create("Sergio Gonal", "Hola soy sergio 2", toDate("2017-09-08T00:11:22")));
        messages.add(Message.create("Sergio Gonal", "Hola soy sergio 3", toDate("2017-09-08T00:11:22")));

        messages.add(Message.create("Sergio Gonal", "Hola soy sergio 11", toDate("2017-09-09T00:11:22")));
        messages.add(Message.create("Sergio Gonal", "Hola soy sergio 22", toDate("2017-09-09T00:11:22")));
        messages.add(Message.create("Sergio Gonal", "Hola soy sergio 33", toDate("2017-09-09T00:11:22")));

        persistenceService.insert(context, messages);
    }

}
