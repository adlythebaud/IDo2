package com.mycabbages.teamavatar.ido2;

import java.util.Date;

/**
 * @author Madison
 */
public class TextMessage {
    private String messageText;
    private String messageUser;
    private long messageTime;

    /**
     * Default constructor to set all variables to their default values
     */
    public TextMessage() {
        messageText = "";
        messageUser = "";

        // Initialize to time zero
        messageTime = 0;
    }

    /**
     * Non-default constructor to create a TextMessage object initialized to the current time.
     *
     * @param messageText String to be put into messageText variable.
     * @param messageUser String to be put into the messageUser varibale.
     */
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
