package com.mycabbages.teamavatar.ido2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddGoalActivity extends AppCompatActivity {
    static final String TAG = "Add_goal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
    }

    public void validate(View view) {
        EditText goalTitle = view.findViewById(R.id.GoalEditText);
    }

    public void cancel(View view) {
        Intent intentToStartMainActivity = new Intent(AddGoalActivity.this,
                MainActivity.class);
        startActivity(intentToStartMainActivity);
    }
}
