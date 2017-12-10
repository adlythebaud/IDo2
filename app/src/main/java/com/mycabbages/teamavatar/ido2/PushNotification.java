package com.mycabbages.teamavatar.ido2;


import android.content.Context;

import java.io.FileNotFoundException;
import java.io.Serializable;

import static java.security.AccessController.getContext;

/**
 * Created by Preston on 11/17/2017.
 */

public class PushNotification implements Serializable {

    private long timeToSend;
    private String message;
    private String notificationTitle;
    Context context;
    private boolean sent;
    public PushNotification(){
        sent = false;
    }

    public PushNotification(Context context,String message, String notificationTitle, long timeToSend) {
        this.message = message;
        this.notificationTitle = notificationTitle;
        this.timeToSend = timeToSend;
        this.sent = false;
        this.context = context;
        ReadWrite push = new ReadWrite();
        try {
            push.addNotification(this.context, this.getMessage(), this.getNotificationTitle(), this.getTimeToSend());
        }catch(Exception e){
            new FileNotFoundException();
        }
    }

    public long getTimeToSend() {
        return timeToSend;
    }
    public void setTimeToSend(long timeToSend) {
        this.timeToSend = timeToSend;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setNotificationTitle(String title) { this.notificationTitle = title; }
    public String getNotificationTitle() { return notificationTitle; }

    public boolean isSent() {
        return sent;
    }
    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
