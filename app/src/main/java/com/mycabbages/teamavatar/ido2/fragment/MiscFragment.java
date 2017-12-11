package com.mycabbages.teamavatar.ido2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mycabbages.teamavatar.ido2.LoginActivity;
import com.mycabbages.teamavatar.ido2.MainActivity;
import com.mycabbages.teamavatar.ido2.R;
import com.mycabbages.teamavatar.ido2.User;
import com.mycabbages.teamavatar.ido2.CoupleQuiz;

/**
 * Created by Preston on 11/17/2017
 */
public class MiscFragment extends BaseFragment {
    static final String TAG = "quiz_log";
    private Button mCuppleQuiz;
    private TextView score;

    /*
    * Creates a MiscFragment and returns it
    */
    public static MiscFragment create() {
        return new MiscFragment();
    }

    /*
    * Returns the Misc Fragment Resource Resource ID
    */
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_misc;
    }

    /*
    * Called after onCreateView after the layout is inflated.
    */
    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCuppleQuiz = (Button) root.findViewById(R.id.couples_quiz);
        mCuppleQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToCallCoupleQuiz = new Intent(getActivity(), CoupleQuiz.class);
                startActivity(intentToCallCoupleQuiz);
            }
        });
        User user = new User();
        score = root.findViewById(R.id.score_text);
        score.setText(String.valueOf( user.getmQuizScore()));
    }
}