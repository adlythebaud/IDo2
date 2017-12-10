package com.mycabbages.teamavatar.ido2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mycabbages.teamavatar.ido2.R;
import com.mycabbages.teamavatar.ido2.User;
import com.mycabbages.teamavatar.ido2.View.CoupleQuiz;

/**
 * Created by Preston on 11/17/2017
 */
public class MiscFragment extends BaseFragment {
    static final String TAG = "quiz_log";
    private Button mCuppleQuiz;
    private TextView score;
    public static MiscFragment create() {
        return new MiscFragment();
    }


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_misc;
    }

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
