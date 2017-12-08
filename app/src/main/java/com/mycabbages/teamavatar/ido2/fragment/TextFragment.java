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
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
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
 * This class inflates the UI for the texting fragment. Contains the business logic for sending
 * Text Messages to the Users connected spouse.
 *
 * Uses Firebase to store the messages sent between the User and their spouse. This also inflates
 * the UI necessary for the User to see they messages they sent to their spouse and the messages
 * recieved from their spouse.
 *
 * @author Madison
 */
public class TextFragment extends BaseFragment {

    public final static String TEXTLOG = "Text_log";
    private DatabaseReference mDatabase;
    private DatabaseReference mCoupleDatabase;
    private DatabaseReference mUserDatabase;
    private FirebaseUser mUser;
    private String coupleID;
    private String uUID;
    private String firstName;
    private FirebaseListAdapter<TextMessage> firebaseAdapter;
    private ListView listOfMessages;

    /*
    * Creates a new TextFragment and returns it
    */
    public static TextFragment create () { return new TextFragment(); }

    /*
    * Displays the list of messages retrieved from Firebase
    * try to pass in mCoupleDatabase into here.
    */
    private void displayChatMessages(){
        Log.d("Text Fragment", "mCoupleDatabase from within displayChatMessages: " + mCoupleDatabase);
        // Retrieve the list of messages from the Couple section in Firebase.
        firebaseAdapter = new FirebaseListAdapter<TextMessage>(super.getActivity(),
                TextMessage.class, R.layout.message,
                FirebaseDatabase.getInstance().getReferenceFromUrl("https://ido2-18f4f.firebaseio.com/couples/pyan12345/chat")) {
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

        listOfMessages.setAdapter(firebaseAdapter);

    }

    /*
    * Returns the layout resource ID for the TextFragment
    */
    @Override
    public int getLayoutResId() { return R.layout.fragment_text;}

    /*
    * Used to do any work related to the UI. This function is called after the UI is inflated.
    */
    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listOfMessages = (ListView)root.findViewById(R.id.messageList);
        FloatingActionButton fab = root.findViewById(R.id.sendFab);

        displayChatMessages();

        //Find all the dataBase references
        mUser = FirebaseAuth.getInstance().getCurrentUser();

        if (mUser != null)
            uUID = mUser.getUid();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mUserDatabase = mDatabase.child("users").child(uUID);
        Log.d(TEXTLOG, "mUserDatabase: " + mUserDatabase.toString());

        // get the coupleID from the currently logged in user.
        mDatabase.child("users").child(uUID).child("coupleID").addListenerForSingleValueEvent(new ValueEventListener() {
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




        mUserDatabase.child("firstName").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        try {
                            firstName = dataSnapshot.getValue().toString();
                            Log.d("TextFragment", "firstName found: " + firstName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.d("TextFragment", "no value present for " + mUser.getEmail() + "'s firstName");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("TextFragment", "Cancelled the read for Users first name.");
            }
        });

        // once we have database info, let's display it to the UI.
//        Log.d(TEXTLOG, "looking for " + coupleID + "'s chat ref...");
//
//        // test that we have the ID's...
        Log.d(TEXTLOG, "coupleID Outside of listeners: " + coupleID);
//        mCoupleDatabase = mDatabase.child("couples").child(coupleID).child("chat");
//        Log.d(TEXTLOG, "mCoupleDatabase's chat ref: " + mCoupleDatabase.toString());
//
//        // test that we still have the coupleID outside of the ValueEventListener
//        Log.d("TextFragment", "coupleID found: " + coupleID);
        // Test that we still have the first name outside of the ValueEventListener



        // Add a listener for a click or tap onto the message box.
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = getActivity().findViewById(R.id.messageBox);

                // This allows the message box to move up with the keyboard pop-up
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.
                        SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

                final DatabaseReference newChatMessageRef = mCoupleDatabase.child("chat").push();

                // Read the input field and push a new instance
                // of TextMessage to the Firebase database

                if (!firstName.equals("") && firstName != null)
                    newChatMessageRef.setValue(new TextMessage(input.getText().toString(), firstName));
                else
                    newChatMessageRef.setValue(new TextMessage(input.getText().toString(), mUser.getEmail()));


                // clear the input
                input.setText("");
            }
        });
        displayChatMessages();
    }

}
