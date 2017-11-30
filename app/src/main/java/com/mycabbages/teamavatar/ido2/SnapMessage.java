package com.mycabbages.teamavatar.ido2;

import java.util.Date;

/**
 * Created by Preston on 11/17/2017.
 */

public class SnapMessage {
    private User receivingUser;
    private User sendingUser;
    private long messageTime;

    SnapMessage() {
        receivingUser = null;
        sendingUser = null;

        // Initialize to current time
        messageTime = 0;
    }

    SnapMessage(User receivingUser, User sendingUser) {
        receivingUser = receivingUser;
        sendingUser = sendingUser;

        // Initialize to current time
        messageTime = new Date().getTime();
    }


    public void sendMessage(String message){

    }
}
