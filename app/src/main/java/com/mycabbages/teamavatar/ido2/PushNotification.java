package com.mycabbages.teamavatar.ido2;


import android.app.Activity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Preston on 11/17/2017.
 */

public class PushNotification implements Serializable {

    private long timeToSend;
    private String message;
    private String notificationTitle;
    private boolean sent;

    PushNotification(){
        sent = false;
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
