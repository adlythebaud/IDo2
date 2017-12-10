package com.mycabbages.teamavatar.ido2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//import static com.mycabbages.teamavatar.ido2.MainActivity.goals;

/**
 * An adapter for a ListView that displays the goals for the user to see.
 *
 * @author Conrad
 */
public class GoalListAdapter extends ArrayAdapter<Goal> {
    private ArrayList<Goal> goal ;
    private Context context;
    private int resource = 0;
    private Calendar calendar;

    /**
     *
     * @param context The context running on the app currently
     * @param resource The resource ID for the goal to be displayed
     * @param data The data to be displayed on the LstView
     */
    public GoalListAdapter(@NonNull Context context, int resource, ArrayList<Goal> data) {
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
        ProgressBar progressBar = view.findViewById(R.id.timeLeft);

        calendar = Calendar.getInstance();
        float timeleft =  (float)calendar.getTimeInMillis()- 0/ (0 - 100) * 100;
        progressBar.setProgress((int)timeleft);


        Button checkBox = view.findViewById(R.id.checkBox);

        Goal goals = goal.get(position);

        //adding values to the list item
        textViewName.setText(goals.getGoalTitle());

        return view;
    }
}
