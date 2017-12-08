package com.mycabbages.teamavatar.ido2;


import java.io.Serializable;

/**
 * Allows for easy access to the phone to push notifications onto the Users phone from the app
 *
 * @author Preston
 */
public class PushNotification implements Serializable {
    private long timeToSend;
    private String message;
    private String notificationTitle;
    private boolean sent;

    /**
     * Initializes all fields to an "empty" value
     */
    public PushNotification(){
        notificationTitle = "";
        timeToSend = 0;
        message = "";
        sent = false;
    }

    /**
     * Sets the {@link PushNotification}s message, title, and time to send to the received values.
     *
     * @param message The message of the notification to the user
     * @param notificationTitle The title of the push notification
     * @param timeToSend The time to send the notification to the user
     */
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
