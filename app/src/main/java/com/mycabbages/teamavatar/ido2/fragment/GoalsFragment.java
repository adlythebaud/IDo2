package com.mycabbages.teamavatar.ido2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ImageView;


import com.mycabbages.teamavatar.ido2.AddGoalActivity;
import com.mycabbages.teamavatar.ido2.Goal;
import com.mycabbages.teamavatar.ido2.GoalListAdapter;
import com.mycabbages.teamavatar.ido2.MainActivity;
import com.mycabbages.teamavatar.ido2.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Preston on 11/17/2017.
 */

public class GoalsFragment extends BaseFragment {

    private final static String TAG = "Goals_Fragment";
    private ImageView mAddGoalButton;
    private ImageView mTextNotification;
     public static ArrayList<Goal> goals;
     ListView listView;

     Date date;
     Calendar calendar;

    public static GoalsFragment create() {
        return new GoalsFragment();



    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_goal;
    }

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mAddGoalButton = root.findViewById(R.id.add_goal_button);
        mTextNotification = root.findViewById(R.id.text_notification_button);

        mAddGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Inside Onclick");
                Intent intentToCallAddGoalActivity = new Intent(getActivity(), AddGoalActivity.class);
                startActivity(intentToCallAddGoalActivity);
            }
        });

        //this is to display the goals in the listView
        calendar =  Calendar.getInstance();
        calendar.getTimeInMillis();
        goals = new ArrayList<>();
        goals.add(new Goal("kiss your wife"    , false,calendar));
        goals.add(new Goal("go hunting"        , false,calendar));
        goals.add(new Goal("jump off bridge"   , false,calendar));
        goals.add(new Goal("sky diving"        , false,calendar));
        GoalListAdapter goaladapter = new GoalListAdapter(getContext(), R.id.goal_list, goals);

        //getActivity().setContentView(R.layout.fragment_goal);
        listView = (ListView) root.findViewById(R.id.goal_list);

        if (listView ==null){
            System.out.println(root.findViewById(R.id.goal_list));
            System.out.println(listView + " " +" listview is null ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        if (listView != null) {
            System.out.println("listview is not null ------------------------------------------------------------------------------------------------------------------");
            listView.setAdapter(goaladapter);
        }


    }

}