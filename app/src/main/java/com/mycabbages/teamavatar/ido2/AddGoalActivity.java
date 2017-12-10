package com.mycabbages.teamavatar.ido2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Allows for the user to add a new goal to be reminded of on a later date and time.
 *
 * Controls all the error handling and validating for the user to add goals to their app. This
 * activity will handle all the validating to make sure it is passed the current date and time.
 *
 * @author Preston Higgins
 */
public class AddGoalActivity extends AppCompatActivity {
    static final String TAG = "Add_goal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
    }

    /**
     * Validates the retrieved {@link User} information before creating the {@link Goal}.
     *
     * Checks the {@link Goal} String to make sure information was entered. Puts the time into
     * 24 hour time to be correctly recieved by a {@link GregorianCalendar}. Also removes one from
     * the month to be correctly indexed by the {@link GregorianCalendar}.
     *
     * @param view
     */
    public void validate(View view) {
        // Retrieve all the views that hold the users input
        EditText goalEditText   = (EditText) findViewById(R.id.GoalEditText);
        Spinner monthSpin       = (Spinner) findViewById(R.id.month_spinner);
        Spinner daySpin         = (Spinner) findViewById(R.id.day_spinner);
        Spinner yearSpin        = (Spinner) findViewById(R.id.year_spinner);
        Spinner hourSpin        = (Spinner) findViewById(R.id.hour_spinner);
        Spinner minuteSpin      = (Spinner) findViewById(R.id.minute_spinner);
        Spinner ampmSpin        = (Spinner) findViewById(R.id.am_pm);

        // Pull the users input out of each view component
        String goalTitle    = goalEditText.getText().toString();

        //Subtract 1 from the month for the calendar (Jan == 0 and Dec == 1) according to calendar
        int goalMonth    = Integer.parseInt(monthSpin.getSelectedItem().toString()) - 1;
        int goalDay      = Integer.parseInt(daySpin.getSelectedItem().toString());
        int goalYear     = Integer.parseInt(yearSpin.getSelectedItem().toString());
        int goalHour     = Integer.parseInt(hourSpin.getSelectedItem().toString());
        int goalMinute   = Integer.parseInt(minuteSpin.getSelectedItem().toString());
        String goalAmpm     = ampmSpin.getSelectedItem().toString();

        // If the selection is PM add 12 hours so the GregorianCalender class knows its PM
        if (goalAmpm.equals("PM")) {
            goalHour += 12;
        }

        Log.d(TAG, "Title: " +goalTitle);
        Log.d(TAG, "Month: " + String.valueOf(goalMonth));
        Log.d(TAG, "Day: " + String.valueOf(goalDay));
        Log.d(TAG, "Year: " + String.valueOf(goalYear));
        Log.d(TAG, "Hour: " + String.valueOf(goalHour));
        Log.d(TAG, "Minute: " + String.valueOf(goalMinute));
        Log.d(TAG, goalAmpm);

        // GregorianCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute)
        Calendar goalCompletionTimeAndDate = new GregorianCalendar(goalYear, goalMonth, goalDay, goalHour, goalMinute);

        Log.d(TAG, "C_Month: " + String.valueOf(goalCompletionTimeAndDate.get(Calendar.MONTH)));
        Log.d(TAG, "C_Day: " + String.valueOf(goalCompletionTimeAndDate.get(Calendar.DAY_OF_MONTH)));
        Log.d(TAG, "C_Year: " + String.valueOf(goalCompletionTimeAndDate.get(Calendar.YEAR)));
        Log.d(TAG, "C_Hour: " + String.valueOf(goalCompletionTimeAndDate.get(Calendar.HOUR_OF_DAY)));
        Log.d(TAG, "C_Minute: " + String.valueOf(goalCompletionTimeAndDate.get(Calendar.MINUTE)));
        Log.d(TAG, "C_AM or PM: " + String.valueOf(goalCompletionTimeAndDate.get(Calendar.AM_PM)));

        //TODO: Add the ability for all the info to be added into the users goals

        User user = new User();
        Goal newGoal = new Goal(goalTitle, false, goalCompletionTimeAndDate);
        user.addGoal(newGoal);
        PushNotification push = new PushNotification(this ,newGoal.getGoalTitle(),
                "IDo Goal",newGoal.getDateAndTimeToComplete().getTimeInMillis() - 18000000);
        returnToMainActivity(view);
    }

    /*
    * If the cancel button is clicked this function is called. This will return the user back
    * to the MainActvity.
    */
    public void returnToMainActivity(View view) {
        // Return to the MainActivity if the user cancels
        Intent intentToStartMainActivity = new Intent(AddGoalActivity.this,
                MainActivity.class);
        startActivity(intentToStartMainActivity);
    }
    public void addGoal(View view){

    }
}
