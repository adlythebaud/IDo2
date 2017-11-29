package com.mycabbages.teamavatar.ido2;


import java.util.Date;

/**
 * Created by Conrad on 11/3/2017.
 */

public class Goal {
    private Date date;
    private String title;
    private Boolean completed;

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public String getGoalTitle() { return title; }
    public void setGoalTitle(String title){
        this.title = title;
    }

    public boolean getCompleted(){ return completed; }
    public void setCompleted(Boolean completed) { this.completed = completed; }

}
