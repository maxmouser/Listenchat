package edu.utn.listenchat.model;

import java.util.Date;

import static edu.utn.listenchat.utils.DateUtils.toStringUntilMinute;
import static java.lang.String.format;

public class Message {

    private String intentId;
    private String name;
    private String message;
    private String leido;
    private Date receivedDate;

    public static Message create(String contact, String text, Date date) {
        Message message = new Message();

        message.setIntentId(format("%s-%s-%s", toStringUntilMinute(date), contact, text));
        message.setName(contact);
        message.setMessage(text);
        message.setReceivedDate(date);
        message.setLeido("N");

        return message;
    }

    public String getIntentId() {
        return intentId;
    }

    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLeido() {
        return leido;
    }

    public void setLeido(String leido) {
        this.leido = leido;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }
}

