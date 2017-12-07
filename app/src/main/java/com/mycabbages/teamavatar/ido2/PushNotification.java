package com.mycabbages.teamavatar.ido2;


import java.io.Serializable;

/**
 * Created by Preston on 11/17/2017.
 */

public class PushNotification implements Serializable {

    private long timeToSend;
    private String message;
    private String notificationTitle;
    private boolean sent;
    public PushNotification(){
        sent = false;
    }

    public PushNotification(String message, String notificationTitle, long timeToSend) {
        this.message = message;
        this.notificationTitle = notificationTitle;
        this.timeToSend = timeToSend;
        this.sent = false;
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
