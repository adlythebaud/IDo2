package com.mycabbages.teamavatar.ido2;

import java.util.Date;

/**
 * Created by Preston on 11/17/2017.
 */

public class TextMessage implements Message {
    private String _messageText;
    private String _messageUser;
    private long _timeTextReceived;
    private long _timeTextSent;

    TextMessage() {
        _messageText = "";
        _messageUser = "";
        _timeTextReceived = (long) 0.0;
        _timeTextSent = (long) 0.0;
    }

    TextMessage(String messageText, String messageUser) {
        _messageText = messageText;
        _messageUser = messageUser;
        _timeTextReceived = (long) 0.0;
        _timeTextSent = (long) 0.0;
    }

    public void setDateReceived(Date dateReceived) { _timeTextReceived = dateReceived.getTime(); }
    public Date getDateReceived() { return new Date(_timeTextReceived); }

    public Date getDateSent() { return new Date(_timeTextSent); }
    public void setDateSent(Date dateSent) { _timeTextSent = dateSent.getTime(); }

    public void sendMessage(String message) {}
}
