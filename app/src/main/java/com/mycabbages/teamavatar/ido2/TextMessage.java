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
    public TextMessage() {
        messageText = "";
        messageUser = "";

        // Initialize to current time
        messageTime = 0;
    }

    public TextMessage(String messageText, String messageUser) {
        this.messageText = messageText;
        this.messageUser = messageUser;

        // Initialize to current time
        messageTime = new Date().getTime();
    }

    public TextMessage(String messageText, long messageTime, String messageUser) {
        this.messageText = messageText;
        this.messageTime = messageTime;
        this.messageUser = messageUser;
    }

    // Getters and Setters
    public String getMessageUser() {
        return messageUser;
    }
    public void setMessageUser(String messageUser) { this.messageUser = messageUser; }

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
