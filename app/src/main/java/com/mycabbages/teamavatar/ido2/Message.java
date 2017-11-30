package com.mycabbages.teamavatar.ido2;

import java.util.Date;

/**
 * Created by Preston on 11/17/2017.
 */

public interface Message {
    public void sendMessage(String message);

    // Getters and setters
    public long getMessageTime();
    public void setMessageTime(long messageTime);

}
