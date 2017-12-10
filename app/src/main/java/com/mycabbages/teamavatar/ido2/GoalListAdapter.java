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
 * Created by Conrad on 12/2/2017.
 */

public class GoalListAdapter extends ArrayAdapter<Goal> {
    ArrayList<Goal> goal ;
    private Context context;
    int resource = 0;
    int index;
    Calendar calendar;


    public GoalListAdapter(@NonNull Context context, int resource, ArrayList<Goal> data) {
        super(context, resource, data);
        this.context = context;
        this.goal = data;
        this.resource = resource;
        System.out.println(resource + " this is in goal adapter");

    }


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
       // long timeNow = date.getTime();

        //calendar.setTime(date);
        Calendar calendar1;
        Calendar cal = new GregorianCalendar();
        calendar1 = goal.get(position).getDateAndTimeToComplete();
        //calendar1 = calendar - calendar1;
        long timeFinish = calendar1.getTimeInMillis();



        System.out.println("Time in millsec. till 18:30 = "
                + (cal.getTimeInMillis() - System.currentTimeMillis()));
        long timeLeft = (cal.getTimeInMillis() - System.currentTimeMillis());


        int hrs = (int) (MILLISECONDS.toHours(timeLeft) % 24);
        int min = (int) (MILLISECONDS.toMinutes(timeLeft) % 60);
        int days = (int) (MILLISECONDS.toDays(timeLeft) % 31);

        textViewTime.setText(days+" days "+hrs+" hours "+min+" minutes ");

        ImageButton checkBox = view.findViewById(R.id.checkBox);

        Goal goals = goal.get(position);
        textViewName.setText(goals.getGoalTitle());

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("button pushed");
//                //we will call this method to remove the selected value from the list
//                //we are passing the position which is to be removed in the method
//              removeGoal(position);
                goal.remove(position);
                //reloading the list
                notifyDataSetChanged();
            }
        });
        return view;
    }




//    private void removeGoal(final int position) {
//        //Creating an alert dialog to confirm the deletion
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("Are you sure you want to delete this?");
//
//        //if the response is positive in the alert
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                //removing the item
//                goal.remove(position);
//                //reloading the list
//                notifyDataSetChanged();
//            }
//        });
//    }
}
