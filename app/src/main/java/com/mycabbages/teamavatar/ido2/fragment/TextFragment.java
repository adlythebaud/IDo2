package com.mycabbages.teamavatar.ido2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mycabbages.teamavatar.ido2.R;
import com.mycabbages.teamavatar.ido2.TextMessage;

/**
 * Created by Madison on 11/29/2017.
 */

public class TextFragment extends BaseFragment {

    private DatabaseReference mDatabase;
    private FirebaseUser mUser;
    private ListAdapter adapter;

    public static TextFragment create () { return new TextFragment(); }

    private void displayChatMessages(){

        /*ListView listOfMessages = (ListView)findViewById(R.id.messageList);

        adapter = new FirebaseListAdapter<TextMessage>(this, TextMessage.class,
                R.layout.message, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, TextMessage model, int position) {
                // Get references to the views of message.xml
                TextView messageText = (TextView)v.findViewById(R.id.message_text);
                TextView messageUser = (TextView)v.findViewById(R.id.message_user);
                TextView messageTime = (TextView)v.findViewById(R.id.message_time);

                // Set their text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

                // Format the date before showing it
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };

        listOfMessages.setAdapter(adapter);*/

    }

    @Override
    public int getLayoutResId() { return R.layout.fragment_text;}

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        displayChatMessages();

        FloatingActionButton fab = root.findViewById(R.id.sendFab);

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        final String firstName = mDatabase.child("users").child(mUser.getUid()).child("firstName").toString();
        Log.d("TextFragment", "firstName found: " + firstName);

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
