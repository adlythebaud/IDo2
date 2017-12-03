package com.mycabbages.teamavatar.ido2;


import java.util.Date;

/**
 * Created by Conrad on 11/3/2017.
 */

public class Goal {
    private long startDate;
    private String title;
    private Boolean completed;
    private long endDate;

    public long getStartDate(){
        return startDate;
    }
    public void setStartDate(long startDate){
        this.startDate = startDate;
    }

    public String getGoalTitle() { return title; }
    public void setGoalTitle(String title){
        this.title = title;
    }

    public boolean getCompleted(){ return completed; }
    public void setCompleted(Boolean completed) { this.completed = completed; }

    public long getEndDate() {return endDate;}

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }
}
