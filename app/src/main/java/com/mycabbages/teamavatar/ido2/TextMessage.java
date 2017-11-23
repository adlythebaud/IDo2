package com.mycabbages.teamavatar.ido2;

import java.util.Date;

/**
 * Created by Madison on 11/23/2017.
 */

public class TextMessage {
    private String _messageText;
    private String _messageUser;
    private long _messageTime;

    TextMessage() {
        _messageText = "";
        _messageUser = "";
        _messageTime = (long) 0.0;
    }

    TextMessage(String messageText, String messageUser) {
        this._messageText = messageText;
        this._messageUser = messageUser;
        this._messageTime = new Date().getTime();
    }

    public String getMessageText() { return _messageText; }
    public void setMessageText(String messageText) { this._messageText = messageText; }

    public String getMessageUser() { return _messageUser; }
    public void setMessageUser(String messageUser) { this._messageUser = messageUser; }

    public long getMessageTime() { return _messageTime; }
    public void setMessageTime(long messageTime) { this._messageTime = messageTime; }
}
