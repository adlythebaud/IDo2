package com.mycabbages.teamavatar.ido2;

import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *  A class that holds the needed member variables and functions to allow consistently over the
 *  app for the user.
 *
 *  This class holds the Users name, coupleID, list of goals and some important dates. This class
 *  will help with consistency over the whole application, giving easy access to needed data.
 *
 *  @author Preston Higgins
 *
 */

public class User {
    // A tag for Log
    public static final String USERLOG = "User_log";

    // The users fields
    private String mEmail;
    private Date mBirthday;
    private String mLastName;
    private String mCoupleID;
    static private List<Goal> mGoals = new Vector<Goal>();
    private String mFirstName;

    /**
     *  Sets all the Users fields to an empty value.
     */
    public User() {
        mEmail = "";
        mBirthday = null;
        mLastName = "";
        mCoupleID = "";
        mFirstName = "";
    }

    /**
     * Constructs a new User with the given email
     *
     * @param email
     */
    public User(String email) {
        mEmail = email;
        mBirthday = null;
        mLastName = "";
        mCoupleID = "";
        mFirstName = "";
    }

    /**
     * Constructs a new {@link User} with the given name, coupleID, and email.
     *
     * @param firstName
     * @param lastName
     * @param coupleID
     * @param email
     */
    public User(String firstName, String lastName, String coupleID, String email) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mCoupleID = coupleID;
        this.mEmail = email;
    }

    //Getters and Setters
    public String getEmail() { return mEmail; }
    public void setEmail(String email) { mEmail = email; }

    public Date getBirthday() { return mBirthday; }
    public void setBirthday(Date birthday) { mBirthday = birthday; }

    public String getLastName() { return mLastName; }
    public void setLastName(String lastName) { mLastName = lastName; }

    public String getFirstName() { return mFirstName; }
    public void setFirstName(String firstName) { mFirstName = firstName; }

    public String getCoupleID() { return mCoupleID; }
    public void setCoupleID(String coupleID) { mCoupleID = coupleID; }

    public List<Goal> getGoals() { return mGoals; }
    public void setGoals (List<Goal> goals) { mGoals = goals; }
    public void addGoal (Goal newGoal) { mGoals.add(newGoal); }
}