package com.mycabbages.teamavatar.ido2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.mycabbages.teamavatar.ido2.R;
import com.mycabbages.teamavatar.ido2.TextMessage;

/**
 * Created by Preston on 11/28/2017.
 */

public class TextFragment extends BaseFragment {

    public static TextFragment create () { return new TextFragment(); }

    // onCreate() for our TextFragment
    public void init(){
        Log.d("Text_Log", "Inside init!");


    }

    @Override
    public int getLayoutResId() { return R.layout.fragment_text;}

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Causing crash. See Log Cat
        FloatingActionButton fab = root.findViewById(R.id.sendFab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = getActivity().findViewById(R.id.messageBox);

                // Read the input field and push a new instance
                // of TextMessage to the Firebase database
                FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new TextMessage(input.getText().toString(),
                                FirebaseAuth.getInstance().getCurrentUser()
                                        .getDisplayName()));

                // clear the input
                input.setText("");
            }
        });

    }
}
