package com.mycabbages.teamavatar.ido2;

import java.util.Date;

/**
 * Created by Preston on 11/17/2017.
 */

public interface Message {
    public void sendMessage(String message);
    public Date getDateSent();
    public void setDateSent(Date dateSent);
    public Date getDateReceived();
    public void setDateReceived(Date dateRecived);
}
