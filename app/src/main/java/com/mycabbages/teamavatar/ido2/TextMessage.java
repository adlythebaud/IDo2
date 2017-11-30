package com.mycabbages.teamavatar.ido2;

import java.util.Date;

/**
 * Created by Preston on 11/17/2017.
 */

public class TextMessage {
    private String messageText;
    private String messageUser;
    private long messageTime;

    // Constructors
    TextMessage() {
        messageText = "";
        messageUser = "";

        // Initialize to current time
        messageTime = 0;
    }

    TextMessage(String messageText, String messageUser) {
        messageText = messageText;
        messageUser = messageUser;

        // Initialize to current time
        messageTime = new Date().getTime();
    }

    public void sendMessage(String message) {

    }

    // Getters and Setters
    public String getMessageUser() {
        return messageUser;
    }
    public void setMessageUser(String messageUser) {
        this.messageText = messageUser;
    }

    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public long getMessageTime() {
        return messageTime;
    }
    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
