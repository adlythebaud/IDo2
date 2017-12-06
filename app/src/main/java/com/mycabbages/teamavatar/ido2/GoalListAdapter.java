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
 * Created by Conrad on 12/2/2017.
 */

public class GoalListAdapter extends ArrayAdapter<Goal> {
    ArrayList<Goal> goal ;
    private Context context;
    int resource = 0;
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
            //calendar.getTimeInMillis();

            TextView textViewName = view.findViewById(R.id.goal);
            //TextView textViewTeam = view.findViewById(R.id.textViewTeam);
        ProgressBar progressBar = view.findViewById(R.id.timeLeft);

        calendar = Calendar.getInstance();
        float timeleft =  (((float)calendar.getTimeInMillis()- goal.get(position).getStartDate())/
                (goal.get(position).getStartDate() - goal.get(position).getEndDate())) * 100;
        progressBar.setProgress((int)timeleft);


            Button checkBox = view.findViewById(R.id.checkBox);

            Goal goals = goal.get(position);
            //System.out.println(position);

            //adding values to the list item

            textViewName.setText(goals.getGoalTitle());

        //adding a click listener to the button to remove item from the list
//        checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //we will call this method to remove the selected value from the list
//                //we are passing the position which is to be removed in the method
//                removeHero(position);
//            }
//        });


        return view;



//    private class GoalHolder{
//        TextView  textGoal;
//    }
//
//
//    public int getCount() {
//
//        if(goal.size()<=0)
//            return 1;
//        return data.size();
//    }
//
//    public Goal getItem(int position) {
//        return position;
//    }
//
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent){
//        RecyclerView.ViewHolder holder =
//    //GoalHolder holder = null;
//    //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//        if (convertView == null) {
//            convertView =  inflater.inflate(R.layout.goal_view, parent, false);
//            holder = new GoalHolder();
//            holder.textGoal = (TextView) convertView.findViewById(R.id.goal);
//            convertView.setTag(holder);
//
//
////            Goal goals = getItem(postition);
////            TextView goalText = (TextView) customView.findViewById(R.id.goal_list);
////            goalText.setText(goals.getGoalTitle());
//
//        }
//        else {
//            holder = (GoalHolder) convertView.getTag();
//        }
//
//
//        Goal goals = goal.get(position);



        //return convertView;

    }
}
