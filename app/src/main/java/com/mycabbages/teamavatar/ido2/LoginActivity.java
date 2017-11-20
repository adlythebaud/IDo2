package com.mycabbages.teamavatar.ido2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    public final static String LOGINLOG = "Login_log";

    private FirebaseAuth myAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = myAuth.getCurrentUser();
        updateUI(currentUser);
    }

    public void signUpNewUser(View view) {
        EditText _email = findViewById(R.id.emailInput);
        EditText _password = findViewById(R.id.passwordInput);
        String email = _email.getText().toString();
        String password = _password.getText().toString();
        Log.d(LOGINLOG, email);
        Log.d(LOGINLOG, password);


        Log.d(LOGINLOG, "About to go into Firebase Create User");
        myAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(LOGINLOG, "Inside the oncomplete: " + task.isSuccessful());
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(LOGINLOG, "createUserWithEmail:success");
                            Intent intentToStartMainActivity = new Intent(LoginActivity.this,
                                    MainActivity.class);
                            startActivity(intentToStartMainActivity);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(LOGINLOG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    public void signInExistingUser(View view) {
        EditText _email = findViewById(R.id.emailInput);
        EditText _password = findViewById(R.id.passwordInput);
        String email = _email.getText().toString();
        String password = _password.getText().toString();
        Log.d(LOGINLOG, email);
        Log.d(LOGINLOG, password);

        myAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(LOGINLOG, "signInWithEmail:success");
                            Intent intentToStartMainActivity = new Intent(LoginActivity.this,
                                    MainActivity.class);
                            startActivity(intentToStartMainActivity);
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

    private void updateUI(FirebaseUser user) {

    }
}
