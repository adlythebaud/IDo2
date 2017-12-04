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

        FloatingActionButton fab = root.findViewById(R.id.sendFab);

        mUser = FirebaseAuth.getInstance().getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance().getReference();



        //TODO: remove https://ido2-18f4f.firebaseio.com/users/ from the uUID variable
        final String uUID = mDatabase.child("users").child(mUser.getUid()).toString();
        Log.d("TextFragment", "firstName found: " + uUID);
        // this will give you: https://ido2-18f4f.firebaseio.com/users/F5KkF3x5tnbGoUqp9XjHN78Cf4I2



//        final DatabaseReference coupleChatRef = mDatabase.child("couples").child(coupleID).child("chat").push();



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = getActivity().findViewById(R.id.messageBox);

                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

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
