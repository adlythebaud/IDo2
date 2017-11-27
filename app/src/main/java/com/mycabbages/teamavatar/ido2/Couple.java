package com.mycabbages.teamavatar.ido2;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Created by Preston on 11/17/2017.
 */

public class Couple {
    public final String COUPLELOG = "Couple_log";
    private User _spouse1;
    private User _spouse2;
    private Chat _coupleChat;
    private Date _anniversary;
    private Map<Date, Goal> _importantDates;
    private List<PushNotification> _pushNotifications;
    private String _coupleID;

    public Couple(Activity activity) {
        _spouse1 = null;
        _spouse2 = null;
        _coupleChat = null;
        _anniversary = null;
        _importantDates = new TreeMap<Date, Goal>();
        _pushNotifications = new ArrayList<PushNotification>();
        _coupleID = "";
    }

    public Couple(Activity activity, User spouse1, User spouse2, Date anniversary, Chat coupleChat, String coupleID) {
        _spouse1 = spouse1;
        _spouse2 = spouse2;
        _anniversary = anniversary;
        _coupleChat = coupleChat;
        _importantDates = new TreeMap<Date, Goal>();
        _pushNotifications = new ArrayList<PushNotification>();
        _coupleID = coupleID;
    }

    public User getSpouse1() { return _spouse1; }
    public User getSpouse2() { return _spouse2; }

    public void setSpouse1(User spouse1) { this._spouse1 = spouse1; }
    public void setSpouse2(User spouse2) { this._spouse2 = spouse2; }

    public Chat getChat() { return _coupleChat;}
    public void setChat(Chat coupleChat) { this._coupleChat = coupleChat; }

    public Map<Date, Goal> getImportantDates() { return _importantDates; }
    public void setImportantDates(Map<Date, Goal> importantDates) { this._importantDates = importantDates; }

    public List<PushNotification> getPushNotifications() { return _pushNotifications; }
    public void setPushNotifications(List<PushNotification> pushNotifications) { this._pushNotifications = pushNotifications; }

    public Date getAnniversary() { return _anniversary; }
    public void setAnniversary(Date anniversary) { this._anniversary = anniversary; }

    public void createCoupleID () { this._coupleID =  UUID.randomUUID().toString();
        Log.d(COUPLELOG, _coupleID);}
}
