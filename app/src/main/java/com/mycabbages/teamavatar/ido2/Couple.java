package com.mycabbages.teamavatar.ido2;

import android.app.Activity;
import android.util.Log;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Handles the data needed for the {@link User} to be connected to their spouse while using the app.
 *
 * Connects the {@link User} to their spouse through this object. The data needed to chat with
 * the users spouse as well as the important dates the user needs to know about their spouse.
 *
 * @author Preston Higgins
 */

public class Couple {
    public final String COUPLELOG = "Couple_log";
    private User mSpouse1;
    private User mSpouse2;
    private Date mAnniversary;
    private Map<String, Goal> mImportantDates;
    private List<PushNotification> mPushNotifications;
    private String mCoupleID;
    private String mLastName;


    /**
     * Creates a Couple and sets all fields to an empty, or null value.
     */
    public Couple() {
        mSpouse1 = null;
        mSpouse2 = null;
        mAnniversary = null;
        mImportantDates = new TreeMap<String, Goal>();
        mPushNotifications = new ArrayList<PushNotification>();
        mCoupleID = "";
    }

    /**
     * Instantiates a class setting a value for the couples last name, each spouse, and their chat.
     *
     * Constructs a couple object giving a value to the couples last name, setting a value for both
     * spouses, and setting up the couples chat. Normally, used when signing up a new user that
     * gave information pertaining to their spouse.
     *
     * @param lastName
     * @param spouse1
     * @param spouse2
     */
    public Couple(String lastName, User spouse1, User spouse2) {
        this.mSpouse1 = spouse1;
        this.mSpouse2 = spouse2;
        this.mLastName = lastName;
    }

    /**
     * Create a couple setting the values for their last name, each spouse, their anniversary,
     * their own couple chat, and their coupleID.
     *
     * If their user has given a coupleID to create their account with this creates a couple object
     * with their coupleID. This also sets the fields for each spouse, their anniversary, and their
     * chat.
     *
     * @param spouse1
     * @param spouse2
     * @param anniversary
     * @param coupleID
     */
    public Couple(User spouse1, User spouse2, Date anniversary, String coupleID) {
        this.mSpouse1 = spouse1;
        this.mSpouse2 = spouse2;
        mAnniversary = anniversary;
        mImportantDates = new TreeMap<String, Goal>();
        mPushNotifications = new ArrayList<PushNotification>();
        mCoupleID = coupleID;
    }

    public User getSpouse1() { return mSpouse1; }
    public User getSpouse2() { return mSpouse2; }

    public void setSpouse1(User spouse1) { this.mSpouse1 = spouse1; }
    public void setSpouse2(User spouse2) { this.mSpouse2 = spouse2; }

    public Map<String, Goal> getImportantDates() {
        return mImportantDates;
    }
    public void setImportantDates(Map<String, Goal> importantDates) {
        this.mImportantDates = mImportantDates;
    }


    public List<PushNotification> getPushNotifications() { return mPushNotifications; }
    public void setPushNotifications(List<PushNotification> pushNotifications) {
        this.mPushNotifications = pushNotifications;
    }

    public Date getAnniversary() { return mAnniversary; }
    public void setAnniversary(Date anniversary) { this.mAnniversary = anniversary; }

    /**
     * Creates a unique couple ID for the user using the {@link UUID} library.
     *
     * @see UUID
     */
    public void createCoupleID () {
        this.mCoupleID =  UUID.randomUUID().toString();
        Log.d(COUPLELOG, mCoupleID);

    }

    public String getLastName() {
        return mLastName;
    }
    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }
}
