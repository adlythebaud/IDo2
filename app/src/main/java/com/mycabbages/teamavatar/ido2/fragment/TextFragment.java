package com.mycabbages.teamavatar.ido2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mycabbages.teamavatar.ido2.R;
import com.mycabbages.teamavatar.ido2.TextMessage;

/**
 * Created by Preston on 11/28/2017.
 */

public class TextFragment extends BaseFragment {

    private DatabaseReference mDatabase;
    private FirebaseUser mUser;
    private DatabaseReference coupleChatRef;
    private String coupleID;
    private String uUID;

    public static TextFragment create () { return new TextFragment(); }

    @Override
    public int getLayoutResId() { return R.layout.fragment_text;}

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        uUID = mUser.getUid();

        coupleID = getCoupleID();
        final DatabaseReference newChatMessageRef = mDatabase.child("couples").child(coupleID).child("chat").push();

        FloatingActionButton fab = root.findViewById(R.id.sendFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = getActivity().findViewById(R.id.messageBox);

                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.
                        SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

                // Read the input field and push a new instance
                // of TextMessage to the Firebase database

                newChatMessageRef.setValue(new TextMessage(input.getText().toString(),
                        mUser.getEmail()));

                // clear the input
                input.setText("");
            }
        });
    }
    
    /**
     * GET COUPLE ID
     *  Return coupleID of current user.
     */
    public String getCoupleID() {
        mDatabase.child("users").child(uUID).child("coupleID").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        try {
                            coupleID = dataSnapshot.getValue().toString();
                            Log.d("TextFragment", "coupleID found: " + coupleID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.d("TextFragment", "no value present for " + mUser.getEmail() + "'s coupleID");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("TextFragment", "cancelled to read coupleID");
            }
        });

        String theCoupleID = coupleID;
        return theCoupleID;
    }


}
