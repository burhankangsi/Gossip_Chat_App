package com.example.nimpat_burhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.auth.User;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {
     MaterialEditText met_login_id,met_login_pass;
     Button btn_login;

     TextView tv_login_title, tv_login_forgot_pass, tv_login_sign_up;
     ImageView img_login;
     FirebaseAuth mFirebaseAuth;
     FirebaseUser mFirebaseUser;
     FirebaseAuth.AuthStateListener mAuthStateListener;
     ProgressDialog dialog;
     public static final String userEmail="";
     String userpass, email;
     public static final String TAG="LOGIN";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        met_login_id=(MaterialEditText)findViewById(R.id.met_login_email);
        met_login_pass=(MaterialEditText)findViewById(R.id.met_login_pass);
        btn_login=(Button)findViewById(R.id.btn_login_loginpage);
        tv_login_title = (TextView) findViewById(R.id.txt_login_title);
        tv_login_forgot_pass = (TextView) findViewById(R.id.txt_login_forgot_pass);
        tv_login_sign_up = (TextView) findViewById(R.id.txt_login_sign_up);
        img_login = (ImageView) findViewById(R.id.img_icon);

        dialog = new ProgressDialog(this);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//        databaseReference = FirebaseDatabase.getInstance()
//                .getReference().child("Patients")
//                .child("Patient" + usern).child("Pres");


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
               // mFirebaseUser != null
                if (mFirebaseUser != null)
                {
                    Toast.makeText(MainActivity.this, "You are successfully logged in!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(intent);

                }
                else {
                    Log.d(TAG,"AuthStateChanged:Logout");
                    Toast.makeText(MainActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };
       // mFirebaseAuth.addAuthStateListener(mAuthStateListener);
//        usern = mFirebaseAuth.getInstance().getUid();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  userSignIn();
//                String email = met_login_id.getText().toString();
//                String password = met_login_pass.getText().toString();
//                if (email.isEmpty())
//                {
//                    met_login_id.setError("Please enter Email Id");
//                    met_login_id.requestFocus();
//                }
//                else if (password.isEmpty())
//                {
//                    met_login_pass.setError("Please enter Email Id");
//                    met_login_pass.requestFocus();
//                }
//                else if (email.isEmpty() && password.isEmpty())
//                {
//                    Toast.makeText(MainActivity.this, "Fields are empty !!", Toast.LENGTH_SHORT).show();
//                }
//                else if (!(email.isEmpty() && password.isEmpty()))
//                {
//                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (!task.isSuccessful())
//                            {
//                                Toast.makeText(MainActivity.this, "Error during login, Please try again!", Toast.LENGTH_SHORT).show();
//                            }
//                            else
//                            {
//                                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
//                                startActivity(intent);
//                            }
//                        }
//                    });
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "Error Occurred !!", Toast.LENGTH_SHORT).show();
//                }

            }
        });

        tv_login_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSignUp = new Intent (MainActivity.this, RegisterActivity.class);
                startActivity(intSignUp);
            }
        });
    }

    private void userSignIn() {
        email = met_login_id.getText().toString().trim();
        userpass = met_login_pass.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {

            Toast.makeText(MainActivity.this, "Enter the correct Email", Toast.LENGTH_SHORT).show();

            return;

        } else if (TextUtils.isEmpty(userpass)) {

            Toast.makeText(MainActivity.this, "Enter the correct password", Toast.LENGTH_SHORT).show();
            return;

        }

        dialog.setMessage("Loging in please wait...");

        dialog.setIndeterminate(true);

        dialog.show();
        mFirebaseAuth.signInWithEmailAndPassword(email, userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override

            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()) {

                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "Login not successfull", Toast.LENGTH_SHORT).show();

                } else {

                    dialog.dismiss();

                    checkIfEmailVerified();
                }

            }

        });
    }

    private void checkIfEmailVerified() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        boolean emailVerified = firebaseUser.isEmailVerified();
        if (!emailVerified)
        {
            Toast.makeText(MainActivity.this, "Verify the email Id", Toast.LENGTH_SHORT);
            mFirebaseAuth.signOut();
            finish();
        }
        else {
            met_login_id.getText().clear();
            met_login_pass.getText().clear();
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            // Sending Email to Dashboard Activity using intent.

            intent.putExtra(userEmail,email);
            startActivity(intent);
        }

    }


    protected void onStart()
    {
        super.onStart();
        //removeAuthSateListner is used  in onStart function just for checking purposes,it helps in logging you out.
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
           }

           protected void onStop()
           {
               super.onStop();
               if(mAuthStateListener != null)
                   mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
           }

           public void onBackPressed()
           {
               MainActivity.super.finish();
           }
}
