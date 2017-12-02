package com.mycabbages.teamavatar.ido2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mycabbages.teamavatar.ido2.AddGoalActivity;
import com.mycabbages.teamavatar.ido2.MainActivity;
import com.mycabbages.teamavatar.ido2.R;

/**
 * Created by Preston on 11/17/2017.
 */

public class GoalsFragment extends BaseFragment {
    private final static String TAG = "Goals_Fragment";
    private ImageView mAddGoalButton;
    private ImageView mTextNotification;

    public static GoalsFragment create() {
        return new GoalsFragment();
    }

    @Override
    public void init() {

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
    }
}