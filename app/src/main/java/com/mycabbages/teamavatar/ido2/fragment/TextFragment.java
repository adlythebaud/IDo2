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
    private DatabaseReference mCoupleChatDatabase;
    private DatabaseReference mUserDatabase;
    private FirebaseUser mUser;
    private String coupleID;
    private String uUID;
    private String firstName;
    private FirebaseListAdapter<TextMessage> firebaseAdapter;
    private ListView listOfMessages;

    public static TextFragment create () { return new TextFragment(); }

    @Override
    public int getLayoutResId() { return R.layout.fragment_text;}

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listOfMessages = (ListView)root.findViewById(R.id.messageList);
        FloatingActionButton fab = root.findViewById(R.id.sendFab);

        getFirebaseData();

        /*
         * ON CLICK LISTENER
         * Add a listener for a click or tap onto the message box.
         */
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText input = getActivity().findViewById(R.id.messageBox);

                // This allows the message box to move up with the keyboard pop-up
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.
                        SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

                Log.d("TextFragment", "coupleID from on click listener found: " + coupleID);
                Log.d("TextFragment", "firstName from on click listener found: " + firstName);

                final DatabaseReference newChatMessageRef = mCoupleChatDatabase.push();

                // convert input to TextMessage object and send to correct couple's chat.
                if (input.getText().toString() != "") {
                    if (!firstName.equals("") && firstName != null)
                        newChatMessageRef.setValue(new TextMessage(input.getText().toString(), firstName));
                    else
                        newChatMessageRef.setValue(new TextMessage(input.getText().toString(), mUser.getEmail()));
                }

                // clear the input
                input.setText("");

                // update the UI.
                displayChatMessages();
            }
        });
    }


    /*
     * DISPLAY CHAT MESSAGES
     * Display the chat messages from coupleID's chat child.
     */
    private void displayChatMessages(){

        // make sure we have these values.
        Log.d("TextFragment", "coupleID from displayChatMessages found: " + coupleID);
        Log.d("TextFragment", "firstName from displayChatMessages found: " + firstName);

        // Retrieve the list of messages from the Couple section in Firebase.
        firebaseAdapter = new FirebaseListAdapter<TextMessage>(this.getActivity(),
                TextMessage.class, R.layout.message,
                mCoupleChatDatabase) {
            @Override
            protected void populateView(View v, TextMessage model, int position) {
                // Get references to the views of message.xml
                TextView messageText = (TextView)v.findViewById(R.id.messageText);
                TextView messageUser = (TextView)v.findViewById(R.id.messageUser);
                TextView messageTime = (TextView)v.findViewById(R.id.messageTime);

                // Test that we have the correct text messaage content
                Log.d("messageText", "Text: " + model.getMessageText());
                Log.d("messageText", "User: " + model.getMessageUser());

                // Set the text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

                // Format the date before showing it
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };

        // update the list of messages by querying the order in Firebase.
        listOfMessages.setAdapter(firebaseAdapter);

    }

    /*
     * GET FIREBASE DATA
     * Get the data from firebase
     */
    private void getFirebaseData() {

        // get the uUID from the currently logged in user. Used to access the children in DB.
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mUser != null)
            uUID = mUser.getUid();

        // get instance of database and reference to current user in database.
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mUserDatabase = mDatabase.child("users").child(uUID);

        Log.d(TEXTLOG, "mUserDatabase: " + mUserDatabase.toString());

        // get the coupleID from the currently logged in user.
        mDatabase.child("users").child(uUID).child("coupleID").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    coupleID = dataSnapshot.getValue().toString();
                    mCoupleChatDatabase = mDatabase.child("couples").child(coupleID).child("chat");
                    Log.d("TextFragment", "coupleID found: " + coupleID);
                    Log.d(TEXTLOG, "mCoupleChatDatabase found: " + mCoupleChatDatabase);
                } else {
                    Log.d("TextFragment", "no value present for " + mUser.getEmail() + "'s coupleID");
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("TextFragment", "cancelled to read coupleID");
            }
        });

        // get the first name from the currently logged in user from firebase database.
        mUserDatabase.child("firstName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    firstName = dataSnapshot.getValue().toString();
                    Log.d("TextFragment", "firstName found: " + firstName);

                    // call displayChatMessages because we have all the firebase info we need.
                    displayChatMessages();
                } else {
                    Log.d("TextFragment", "no value present for " + mUser.getEmail() + "'s firstName");
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("TextFragment", "Cancelled the read for Users first name.");
            }
        });
    }
}
    
