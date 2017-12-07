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
    private List<Goal> mGoals;
    private String mFirstName;

    /**
     *  Sets all the Users fields to an empty value.
     */
    private User() {
        mEmail = "";
        mBirthday = null;
        mLastName = "";
        mCoupleID = "";
        mFirstName = "";
        mGoals = new Vector<Goal>();
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
        mGoals = new Vector<Goal>();
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
    protected String getEmail() { return mEmail; }
    protected void setEmail(String email) { mEmail = email; }

    protected Date getBirthday() { return mBirthday; }
    protected void setBirthday(Date birthday) { mBirthday = birthday; }

    protected String getLastName() { return mLastName; }
    protected void setLastName(String lastName) { mLastName = lastName; }

    protected String getFirstName() { return mFirstName; }
    protected void setFirstName(String firstName) { mFirstName = firstName; }

    protected String getCoupleID() { return mCoupleID; }
    protected void setCoupleID(String coupleID) { mCoupleID = coupleID; }

    protected List<Goal> getGoals() { return mGoals; }
    protected void setGoals (List<Goal> goals) { mGoals = goals; }


}