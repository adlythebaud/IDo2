package com.mycabbages.teamavatar.ido2.fragment;

import android.content.Intent;
import android.os.Bundle;
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
import com.mycabbages.teamavatar.ido2.User;


import java.util.ArrayList;
import java.util.List;

/*
 * Inflates the display for the Goals the User have set.
 */
public class GoalsFragment extends BaseFragment {
    private final static String TAG = "Goals_Fragment";
    private ImageView mAddGoalButton;
    private ImageView mTextNotification;

    ListView listView;

    /*
    * Returns the GoalFragment
    */
    public static GoalsFragment create() { return new GoalsFragment();  }

    /*
    * Returns the Layout resource id to the XML
    */
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_goal;
    }

    /*
    * The space there all UI interactions should take place. This is called after the UI is inflated
    */
    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container,
                               @Nullable Bundle savedInstanceState) {
        mAddGoalButton = root.findViewById(R.id.add_goal_button);
        mTextNotification = root.findViewById(R.id.text_notification_button);

        mAddGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Inside Onclick");
                Intent intentToCallAddGoalActivity =
                        new Intent(getActivity(), AddGoalActivity.class);
                startActivity(intentToCallAddGoalActivity);
            }
        });

        User user = new User();

        //this is to display the goals in the listView
        List<Goal> goal = new ArrayList<Goal>();

        goal = user.getGoals();
        GoalListAdapter goaladapter = new GoalListAdapter(getContext(), R.id.goal_list, goal);

        listView = (ListView) root.findViewById(R.id.goal_list);

        if (listView != null)
            listView.setAdapter(goaladapter);

        }

    }
