package com.mycabbages.teamavatar.ido2;


import java.io.Serializable;

/**
 * Holds the information needed for a push notification. This includes the title and the message to
 * be displayed, the time to send it, and whether or not it has been sent or not.
 *
 * @author Preston
 */

public class PushNotification implements Serializable {
    private long timeToSend;
    private String message;
    private String notificationTitle;
    private boolean sent;

    /**
     * Default constructor fills the object with empty variables
     */
    public PushNotification(){
        timeToSend = 0;
        message = "";
        notificationTitle = "";
        sent = false;
    }

    /**
     * Recieves a message, title, and time to send. Will construct the object with the given
     * variables.
     *
     * @param message Message to the user
     * @param notificationTitle Title to let the user know where the notification is coming from
     * @param timeToSend The time the app will send the notification
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
