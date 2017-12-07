package com.mycabbages.teamavatar.ido2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.UUID;
import java.util.Vector;

/**
 * LOGIN ACTIVITY
 */
public class LoginActivity extends AppCompatActivity {
    public final static String LOGINLOG = "Login_log";

    private FirebaseAuth myAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabase;        // this is our database reference.
    private FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myAuth = FirebaseAuth.getInstance();


        FirebaseUser currentUser = myAuth.getCurrentUser();
        updateUI(currentUser);

        // set your DatabaseReference object to our current database.
        mDatabase = FirebaseDatabase.getInstance().getReference();
//        EditText firstNameET     = (EditText)findViewById(R.id.firstNameEditText);
//        EditText lastNameET      = (EditText)findViewById(R.id.lastNameEditText);
//        EditText coupleIDET      = (EditText)findViewById(R.id.coupleIDEditText);
//        firstNameET.setVisibility(View.INVISIBLE);
//        lastNameET.setVisibility(View.INVISIBLE);
//        coupleIDET.setVisibility(View.INVISIBLE);
        // now all calls to FirebaseDatabase are called with mDatabase.
    }

    @Override
    protected void onStart() {
        super.onStart();

        // add listener for auth state changes.
//        myAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();

        // when we log out, remove listener for authorizations.
//        if (mAuthListener != null) {
//            myAuth.removeAuthStateListener(mAuthListener);
//        }
    }



    /*
    * Retrieves the information typed into the editTexts and uses these values to attempt a log in
    * to the firebase authentication server.
    */
    public void signInExistingUser(View view) {
        // Retrieve the editTexts and then put the values into Strings
        EditText emailEditText = findViewById(R.id.emailInput);
        EditText passwordEditText = findViewById(R.id.passwordInput);
        String emailString = emailEditText.getText().toString();
        String passwordString = passwordEditText.getText().toString();

        Log.d(LOGINLOG, emailString);
        Log.d(LOGINLOG, passwordString);

        // Send the user info to firebase to authenticate.
        myAuth.signInWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(LOGINLOG, "signInWithEmail:success");

//                          //TODO: make user object

                            goToHome();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(LOGINLOG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_LONG).show();
                            updateUI(null);
                        }
                    }
                });
    }

    /*
    * Retrieves the information typed by the user to register their account. Sends the retrieved
    * values to fireBase to attempt registering to their authentication servers.
    */
    public void createAccount(final String firstName, final String lastName, final String coupleID,
                              final String email, final String password) {
        // Send data to fireBase to create a new user
        myAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(LOGINLOG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {                             // TASK FAILURE
                            Toast.makeText(LoginActivity.this, "Auth failure.",
                                    Toast.LENGTH_SHORT).show();

                        }
                        if (task.isSuccessful()) {                              // TASK SUCCESSFUL
                            Log.w(LOGINLOG, "createAccountWithEmail:succeeded", task.getException());
                            Toast.makeText(LoginActivity.this, "auth success!",
                                    Toast.LENGTH_SHORT).show();

                            //TODO: need to add last name, first name, coupleID. You don't need password.

                             addUserToDatabase(firstName, lastName, coupleID, email);

                             // start a new intent
                             goToHome();
                        }

                        // ...
                    }
                });
    }

    /*
    * Called when the user clicks the cancel button, this button appears after the user clicks the
    * register button. When clicked it reverts the UI to the sign-up screen.
    */
    public void cancelButton(View view){
        //Get each of the EditText views and Buttons
        EditText firstNameET     = (EditText)findViewById(R.id.firstNameEditText);
        EditText lastNameET      = (EditText)findViewById(R.id.lastNameEditText);
        EditText coupleIDET      = (EditText)findViewById(R.id.coupleIDEditText);
        Button registerButton      = (Button)findViewById(R.id.RegisterButton);
        Button signUp      = (Button)findViewById(R.id.signUp);
        Button cancel      = (Button)findViewById(R.id.CancelButton);
        Button signin      = (Button)findViewById(R.id.signIn);

        //Make correct buttons and texts visible and set correct buttons and texts invisible
        signin.setVisibility(View.VISIBLE);
        cancel.setVisibility(View.INVISIBLE);
        firstNameET.setVisibility(View.INVISIBLE);
        lastNameET.setVisibility(View.INVISIBLE);
        coupleIDET.setVisibility(View.INVISIBLE);
        registerButton.setVisibility(View.VISIBLE);
        signUp.setVisibility(View.INVISIBLE);

    }

    /*
    * When clicked it makes the the First and Last name editTexts visible and changes the buttons
    */
    public void registerButton(View v){
        // Retrieve the necessary EditTexts and Buttons
        EditText firstNameET     = (EditText)findViewById(R.id.firstNameEditText);
        EditText lastNameET      = (EditText)findViewById(R.id.lastNameEditText);
        EditText coupleIDET      = (EditText)findViewById(R.id.coupleIDEditText);
        Button registerButton      = (Button)findViewById(R.id.RegisterButton);
        Button signUp      = (Button)findViewById(R.id.signUp);
        Button cancel      = (Button)findViewById(R.id.CancelButton);
        Button signin      = (Button)findViewById(R.id.signIn);

        // Set the correct EditTexts and Buttons visible and invisible
        signin.setVisibility(View.INVISIBLE);
        cancel.setVisibility(View.VISIBLE);
        firstNameET.setVisibility(View.VISIBLE);
        lastNameET.setVisibility(View.VISIBLE);
        coupleIDET.setVisibility(View.VISIBLE);
        registerButton.setVisibility(View.INVISIBLE);
        signUp.setVisibility(View.VISIBLE);
    }

    /*
    * Controls the UI to display the needed EditsTexts and Buttons to register a new user
    */
    public void registerNewUser(View view) {
        //Retrieve all the EditTexts and Buttons
        EditText firstNameET     = (EditText)findViewById(R.id.firstNameEditText);
        EditText lastNameET      = (EditText)findViewById(R.id.lastNameEditText);
        EditText coupleIDET      = (EditText)findViewById(R.id.coupleIDEditText);
        EditText emailTextBox    = (EditText)findViewById(R.id.emailInput);
        EditText passwordTextBox = (EditText)findViewById(R.id.passwordInput);

        //Set all EditTexts and Buttons invisible or visible as needed
        String firstName = firstNameET.getText().toString();
        String lastName = lastNameET.getText().toString();
        String coupleID = coupleIDET.getText().toString();
        String email = emailTextBox.getText().toString();
        String password = passwordTextBox.getText().toString();

        if (coupleID.trim().length() == 0) {
            coupleID = UUID.randomUUID().toString();
        }

        //Send the info to the createAccount function to call the firebase code
        createAccount(firstName, lastName, coupleID, email, password);

    }

    /*
    * Calls the Firebase code to add the user in to the correct place in the Realtime Firebase data
    * base
    */
    public void addUserToDatabase(String firstName, String lastName, final String coupleID, String email) {
        // Create a User object to store in the database
        final User user = new User(firstName, lastName, coupleID, email);

        // create a couple object. Assume the user is always the husband for now...
        final Couple couple = new Couple(user.getLastName(), user, null, null);


        mUser = FirebaseAuth.getInstance().getCurrentUser();
        // create a new reference under the users in FB, add the user to the database
        DatabaseReference userRef = mDatabase.child("users").child(mUser.getUid());

        // You can change the users ID to be their email address.
        // DatabaseReference userRef = mDatabase.child("users").child(user.getEmail());
        userRef.setValue(user);


        // handle for if coupleID is found in database
        final DatabaseReference couples = mDatabase.child("couples");
        couples.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(coupleID).exists()) {
                    // The coupleID already exists, add this user to the couple...
                    // To determine whether husband or wife needs to be created,
                    // check if the child of this child exists.
                    if (dataSnapshot.child(coupleID).child("spouse1").exists()) {
                        // add wife child.
                        Log.d(LOGINLOG, "adding spouse2 to " + coupleID);
                        DatabaseReference spouse2Ref = couples.child(coupleID).child("spouse2");
                        spouse2Ref.setValue(user);
                    } else {
                        // add husband child.
                        Log.d(LOGINLOG, "adding spouse1 to " + coupleID);
                        DatabaseReference spouse1Ref = couples.child(coupleID).child("spouse1");
                        spouse1Ref.setValue(user);
                    }

                } else {
                    // coupleID does not exist...
                    Log.d(LOGINLOG, "adding new couple to firebase");
                    DatabaseReference coupleRef = mDatabase.child("couples").child(coupleID);
                    coupleRef.setValue(couple);

                    DatabaseReference chatRef =  coupleRef.child("chat");
//                  DatabaseReference notifRef = coupleRef.child(coupleID).child("push notifications").push();

                    Vector <TextMessage> v = new Vector<>();

//                    v.add("Hello! This is a space where you can chat with your boo thang.");
//                    v.add("Send messages to your spouse about whatever you'd like.");
//                    v.add("Don't worry, this is a private space.");



                    TextMessage tm = new TextMessage("test message", user.getFirstName());
                    v.add(tm);

                    chatRef.setValue(v);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // error handle here....
            }
        });


        // save this new user in firebase database tree under "users" child tree.

        // create a new couple in "couples" tree, add user to it.


    }

    /*
     * Start intent to go to next activity after successful login and sign up.
     */
    public void goToHome() {

        // send coupleID and userID across activities.
        Intent intentToStartMainActivity = new Intent(LoginActivity.this,
                MainActivity.class);
        startActivity(intentToStartMainActivity);
    }

    private void updateUI(FirebaseUser user) {

    }


    public void testnotification(View v)throws FileNotFoundException{
        ReadWrite data = new ReadWrite();
        pushImplimentation check = new pushImplimentation();
        Calendar calendar = Calendar.getInstance();
        data.addNotification(getApplicationContext(),"TEST3", "YIPPY3!!!!!!", calendar.getTimeInMillis()+ 200000);
        check.alarmSet(getApplicationContext());
       //check.checkNotifications(getApplicationContext());
    }
}
