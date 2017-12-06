package com.mycabbages.teamavatar.ido2;

import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *  A class that holds the needed member variables and functions to allow consistently over the
 *  app for the user.
 *
 *  This class hols the Users name, coupleID, list of goals and some important dates. This class
 *  will help with consistency over the whole application, giving easy access to needed data.
 *
 *  @author Preston Higgins
 *
 */

public class User {
    public static final String USERLOG = "User_log";
    private static User user = new User();
    private String mEmail;
    private Date mBirthday;
    private String mLastName;
    private String mCoupleID;
    private List<Goal> mGoals;
    private String mFirstName;

    //Default constructor
    private User() {
        mEmail = "";
        mBirthday = null;
        mLastName = "";
        mCoupleID = "";
        mFirstName = "";
        mGoals = new Vector<Goal>();
    }

    public static User getInstance() {
        return user;
    }

    //Took out non-default constructor to get ready for singleton
    /*//Non-default Constructor to initialize the email as user is made
    public User(String email) {
        _email = email;
        _birthday = null;
        _lastName = "";
        _coupleID = "";
        _firstName = "";
        _goals = new Vector<Goal>();
    }

    public User(String _firstName, String _lastName, String _coupleID, String _email) {
        this._firstName = _firstName;
        this._lastName = _lastName;
        this._coupleID = _coupleID;
        this._email = _email;
    }*/

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