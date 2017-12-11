package com.mycabbages.teamavatar.ido2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

//import static com.mycabbages.teamavatar.ido2.MainActivity.goals;

/**
 * An adapter for a ListView that displays the goals for the user to see.
 *
 * @author Conrad
 */
public class GoalListAdapter extends ArrayAdapter<Goal> {
    private List<Goal> goal ;
    private Context context;
    private int resource = 0;
    private Calendar calendar;

    /**
     *
     * @param context The context running on the app currently
     * @param resource The resource ID for the goal to be displayed
     * @param data The data to be displayed on the LstView
     */
    public GoalListAdapter(@NonNull Context context, int resource, List<Goal> data) {
        super(context, resource, data);
        this.context = context;
        this.goal = data;
        this.resource = resource;
        System.out.println(resource + " this is in goal adapter");

    }


    /**
    * Gets the view to display the ListView for the goals
    */
    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.goal_view, null, false);
        }

        TextView textViewName = view.findViewById(R.id.goal);
        TextView textViewTime = view.findViewById(R.id.time_left_text);

        Date date = new Date();

        User user = new User();
        goal = user.getGoals();

        long timeLeft = (goal.get(position).getmLongCalendar() - System.currentTimeMillis());


        int hrs = (int) (MILLISECONDS.toHours(timeLeft) % 24);
        int min = (int) (MILLISECONDS.toMinutes(timeLeft) % 60);
        int days = (int) (MILLISECONDS.toDays(timeLeft) % 31);

        String timeLeftDisplay = days + "days " + hrs + "hours " + min + "minutes";
        textViewTime.setText(timeLeftDisplay);

        ImageButton checkBox = view.findViewById(R.id.checkBox);

        Goal goals = goal.get(position);
        textViewName.setText(goals.getGoalTitle());

        //Listen for the User clicking the check box to remove the goal
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goal.remove(position);
                //reloading the list
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
