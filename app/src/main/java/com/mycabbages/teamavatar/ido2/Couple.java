package com.mycabbages.teamavatar.ido2;

import android.app.Activity;
import android.util.Log;




import java.util.TreeMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Preston on 11/17/2017.
 */

public class Couple {
    public final String COUPLELOG = "Couple_log";
    private User spouse1;
    private User spouse2;
    private Chat _coupleChat;
    private Date _anniversary;
    private Map<String, Goal> _importantDates;
    private List<PushNotification> _pushNotifications;
    private String _coupleID;
    private String _lastName;

    public Couple(Activity activity) {
        spouse1 = null;
        spouse2 = null;
        _coupleChat = null;
        _anniversary = null;
        _importantDates = new TreeMap<String, Goal>();
        _pushNotifications = new ArrayList<PushNotification>();
        _coupleID = "";
    }

    public Couple(Activity activity, User spouse1, User spouse2, Date anniversary, Chat coupleChat, String coupleID) {
        this.spouse1 = spouse1;
        this.spouse2 = spouse2;
        _anniversary = anniversary;
        _coupleChat = coupleChat;
        _importantDates = new TreeMap<String, Goal>();
        _pushNotifications = new ArrayList<PushNotification>();
        _coupleID = coupleID;
    }

    public Couple(String _lastName, User _spouse1, User _spouse2,
                  Chat _coupleChat) {

        this._lastName = _lastName;
        this.spouse1 = _spouse1;
        this.spouse2 = _spouse2;

        this._coupleChat = _coupleChat;
    }

    public User getSpouse1() { return spouse1; }
    public User getSpouse2() { return spouse2; }

    public void setSpouse1(User spouse1) { this.spouse1 = spouse1; }
    public void setSpouse2(User spouse2) { this.spouse2 = spouse2; }

    public Chat getChat() { return _coupleChat;}
    public void setChat(Chat coupleChat) { this._coupleChat = coupleChat; }

    public Map<String, Goal> get_importantDates() {
        return _importantDates;
    }

    public void set_importantDates(Map<String, Goal> _importantDates) {
        this._importantDates = _importantDates;
    }


    public List<PushNotification> getPushNotifications() { return _pushNotifications; }
    public void setPushNotifications(List<PushNotification> pushNotifications) { this._pushNotifications = pushNotifications; }

    public Date getAnniversary() { return _anniversary; }
    public void setAnniversary(Date anniversary) { this._anniversary = anniversary; }

    public void createCoupleID () { this._coupleID =  UUID.randomUUID().toString();
        Log.d(COUPLELOG, _coupleID);}

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }
}
