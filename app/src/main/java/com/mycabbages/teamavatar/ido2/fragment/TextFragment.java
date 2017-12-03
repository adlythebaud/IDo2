package com.mycabbages.teamavatar.ido2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mycabbages.teamavatar.ido2.R;
import com.mycabbages.teamavatar.ido2.TextMessage;

/**
 * Created by Preston on 11/28/2017.
 */

public class TextFragment extends BaseFragment {

    private DatabaseReference mDatabase;
    private FirebaseUser mUser;

    public static TextFragment create () { return new TextFragment(); }

    @Override
    public int getLayoutResId() { return R.layout.fragment_text;}

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Causing crash. See Log Cat
        FloatingActionButton fab = root.findViewById(R.id.sendFab);

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();



        final String uUID = mDatabase.child("users").child(mUser.getUid()).toString();
        Log.d("TextFragment", "firstName found: " + uUID);

        final String firstName = mDatabase.child("users").child(mUser.getUid()).child("firstName").toString();
        Log.d("TextFragment", "firstName found: " + firstName);

//        final String coupleID = mDatabase.child("users").child(mUser.getUid()).child("coupleID").toString();
//        Log.d("TextFragment", "CoupleID found: " + coupleID);

//        final DatabaseReference coupleChatRef = mDatabase.child("couples").child(coupleID).child("chat").push();
        final String coupleID = mDatabase.child("users").child(mUser.getEmail()).child("coupleID").toString();
        Log.d("TextFragment", "CoupleID found: " + coupleID);


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
                                mUser.getEmail()));

                // clear the input
                input.setText("");
            }
        });

    }
}
