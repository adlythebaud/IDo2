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
    private String _email;
    private Date _birthday;
    private String _lastName;
    private String _coupleID;
    private List<Goal> _goals;
    private String _firstName;

    //Default constructor
    public User() {
        _email = "";
        _birthday = null;
        _lastName = "";
        _coupleID = "";
        _firstName = "";
        _goals = new Vector<Goal>();
    }

    //Non-default Constructor to initialize the email as user is made
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
    }

    //Getters and Setters
    public String getEmail() { return _email; }
    public void setEmail(String email) { _email = email; }

    public Date getBirthday() { return _birthday; }
    public void setBirthday(Date birthday) { _birthday = birthday; }

    public String getLastName() { return _lastName; }
    public void setLastName(String lastName) { _lastName = lastName; }

    public String getFirstName() { return _firstName; }
    public void setFirstName(String firstName) { _firstName = firstName; }

    public String getCoupleID() { return _coupleID; }
    public void setCoupleID(String coupleID) { _coupleID = coupleID; }

    public List<Goal> getGoals() { return _goals; }
    public void setGoals (List<Goal> goals) { _goals = goals; }


}