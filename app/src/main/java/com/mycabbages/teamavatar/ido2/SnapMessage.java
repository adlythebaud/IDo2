package com.mycabbages.teamavatar.ido2;

import java.util.Date;

/**
 * Created by Preston on 11/17/2017.
 */

public class SnapMessage implements Message {
    private User _receivingUser;
    private User _sendingUser;
    private long _timeSnapRecieved;
    private long _timeSnapSent;

    SnapMessage() {
        _receivingUser = null;
        _sendingUser = null;
        _timeSnapRecieved = (long)0.0;
        _timeSnapSent = (long)0.0;
    }

    SnapMessage(User receivingUser, User sendingUser) {
        _receivingUser = receivingUser;
        _sendingUser = sendingUser;
        _timeSnapRecieved = (long)0.0;
        _timeSnapSent = (long)0.0;
    }

    public Date getDateSent() { return new Date(_timeSnapSent); }
    public void setDateSent(Date dateSent) { _timeSnapSent = dateSent.getTime(); }

    public Date getDateReceived() { return new Date(_timeSnapRecieved); }
    public void setDateReceived(Date dateRecived) {_timeSnapRecieved = dateRecived.getTime(); }

    public void sendMessage(String message) {}
}
