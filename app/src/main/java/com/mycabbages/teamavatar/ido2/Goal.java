package com.mycabbages.teamavatar.ido2;


import java.util.Date;
import java.util.Calendar;

/**
 * Holds the goal information needed to set, retrieve, and handle goal setting and reminders.
 *
 * Holds the start time of the goals as well as the end time when the user needs to be reminded
 * of it. Holds the goal string, it cam be set or retrieved by the client.
 *
 * @author Conrad
 */
public class Goal {
    private String mTitle;
    private boolean mCompleted;
    private Calendar mDateAndTimeToComplete;
    private long mLongCalendar;

    /**
     * Contructs a new {@link Goal} with empty values
     */
    public Goal() {
        mTitle = "";
        mCompleted = false;
        mDateAndTimeToComplete = null;
        mLongCalendar = 200000;
    }

    /**
     * Constructs a new {@link Goal} with a end {@link Date}, goal String, a boolean for completion.
     *
     * @param title The title to the displayed
     * @param completed is the goal completed
     * @param DateAndTimeToComplete Holds the date (mm-dd-yyyy) and time (hh-mm-ss) to be completed
     */
//    public Goal(String title, boolean completed, Calendar DateAndTimeToComplete) {
//        mTitle = title;
//        mCompleted = completed;
//        mDateAndTimeToComplete = DateAndTimeToComplete;
//    }


    /**
     * Constructs a new {@link Goal} with a end {@link Date}, goal String, a boolean for completion.
     *
     * @param title The title to the displayed
     * @param completed is the goal completed
     * @param mLongCalendar Holds the date (mm-dd-yyyy) and time (hh-mm-ss) to be completed
     */
    public Goal(String title, boolean completed, long mLongCalendar) {
        mTitle = title;
        mCompleted = completed;
        this.mLongCalendar = mLongCalendar;
    }

    public String getGoalTitle() { return mTitle; }
    public void setGoalTitle(String title){
        this.mTitle = title;
    }

    public boolean getCompleted(){ return mCompleted; }
    public void setCompleted(Boolean completed) { this.mCompleted = completed; }

    public Calendar getDateAndTimeToComplete () { return mDateAndTimeToComplete; }
    public void setDateAndTimeToComplete (Calendar dateAndTimeToComplete) {
        this.mDateAndTimeToComplete = dateAndTimeToComplete;
    }

    public Long getmLongCalendar() {
        return mLongCalendar;
    }

    public void setmLongCalendar(Long mLongCalendar) {
        this.mLongCalendar = mLongCalendar;
    }
}
