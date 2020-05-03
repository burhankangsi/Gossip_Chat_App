package com.example.nimpat_burhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nimpat_burhan.Model.User_signup;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Date;
import java.util.concurrent.TimeUnit;


public class RegisterActivity extends AppCompatActivity {
    private MaterialEditText signup_name, signup_email, signup_phone, signup_city, signup_password, signup_reenter_pass;
    private ImageView iv_signup_back;
    // private TextView tv_title_signup;
    private Button btn_register;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference databaseReference;
    // private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signup_name = (MaterialEditText) findViewById(R.id.et_signup_name);
        signup_email = (MaterialEditText) findViewById(R.id.et_signup_email);
        signup_phone = (MaterialEditText) findViewById(R.id.et_signup_phone);
        signup_city = (MaterialEditText) findViewById(R.id.et_signup_city);
        signup_password = (MaterialEditText) findViewById(R.id.et_signup_password);
        signup_reenter_pass = (MaterialEditText) findViewById(R.id.et_signup_reenter_password);

        iv_signup_back = (ImageView) findViewById(R.id.iv_signup_back);
        //tv_title_signup = (TextView) findViewById(R.id.tv_signup_title);
        btn_register = (Button) findViewById(R.id.btn_register);
       mFirebaseAuth = FirebaseAuth.getInstance();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = signup_name.getText().toString().trim();
                String email = signup_name.getText().toString().trim();
                String phone = signup_name.getText().toString().trim();
                String city = signup_city.getText().toString().trim();
                String password = signup_password.getText().toString().trim();
                String repassword = signup_reenter_pass.getText().toString().trim();

                if (name.isEmpty()) {
                    signup_name.setError("Enter a valid name");
                    signup_name.requestFocus();
                    return;
                }  if (email.isEmpty()) {
                    signup_email.setError("Enter a valid email");
                    signup_email.requestFocus();
                    return;
                }  if (phone.isEmpty() || phone.length() < 10) {
                    signup_phone.setError("Enter a valid mobile");
                    signup_phone.requestFocus();
                    return;
                }  if (city.isEmpty()) {
                    signup_city.setError("Enter a valid city");
                    signup_city.requestFocus();
                    return;
                }  if (password.isEmpty() || password.length() < 6) {
                    signup_password.setError("Enter a valid password");
                    signup_password.requestFocus();
                    return;
                }  if (repassword.isEmpty() || repassword != password) {
                    signup_reenter_pass.setError("Passwords do not match");
                    signup_reenter_pass.requestFocus();
                    return;
                }
//                    Intent intent = new Intent(RegisterActivity.this, VerifyPhoneActivity.class);
//                    intent.putExtra("mobile", phone);
//                    startActivity(intent);
//                }

//                  if (TextUtils.isEmpty(name)) {
//                    Toast.makeText(RegisterActivity.this, "Please Enter Name!", Toast.LENGTH_SHORT).show();
//                    return;
//                } else if (TextUtils.isEmpty(email)) {
//                    Toast.makeText(RegisterActivity.this, "Please enter email address!", Toast.LENGTH_SHORT).show();
//                    return;
//                } else if (TextUtils.isEmpty(phone)) {
//                    Toast.makeText(RegisterActivity.this, "Please Enter phone!", Toast.LENGTH_SHORT).show();
//                    return;
//                } else if (TextUtils.isEmpty(city)) {
//                    Toast.makeText(RegisterActivity.this, "Please enter city!", Toast.LENGTH_SHORT).show();
//                    return;
//                } else if (TextUtils.isEmpty(password)) {
//                    Toast.makeText(RegisterActivity.this, "Please enter password!", Toast.LENGTH_SHORT).show();
//                    return;
//                } else if (TextUtils.isEmpty(repassword)) {
//                    Toast.makeText(RegisterActivity.this, "Please reenter password!", Toast.LENGTH_SHORT).show();
//                    return;
//                } else if (password.length() < 6) {
//                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
//                    return;

//                } else if (password != repassword) {
//                    Toast.makeText(getApplicationContext(), "Passwords do not match !!", Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
                  mDialog.setMessage("Creating User please wait...");

                  mDialog.setCanceledOnTouchOutside(false);

//                mDialog.show();
            // Create User
                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                    RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        sendEmailVerification();
                        // mDialog.dismiss();
                        OnAuth(task.getResult().getUser());
                        mFirebaseAuth.signOut();
                    } else {
                        //startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        Toast.makeText(RegisterActivity.this, "Error on creating user!!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }



    });


        iv_signup_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

//    }
//
//    }
//    public void onErrorResponse(VolleyError error) {
//
//        // As of f605da3 the following should work
//        NetworkResponse response = error.networkResponse;
//        if (error instanceof ServerError && response != null) {
//            try {
//                String res = new String(response.data,
//                        HttpHeaderParser.parseCharset(response.headers, "utf-8"));
//                // Now you can use any deserializer to make sense of data
//                JSONObject obj = new JSONObject(res);
//            } catch (UnsupportedEncodingException e1) {
//                // Couldn't properly decode data to string
//                e1.printStackTrace();
//            } catch (JSONException e2) {
//                // returned data is not JSONObject?
//                e2.printStackTrace();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
    }



    // Email Verification code using FirebaseUser object using isSuccessful()
    private void sendEmailVerification() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user!=null){

            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {

                @Override

                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()){

                        Toast.makeText(RegisterActivity.this,"Check your Email for verification",Toast.LENGTH_SHORT).show();

                        FirebaseAuth.getInstance().signOut();

                    }

                }

            });

        }
    }


    private void OnAuth(FirebaseUser user) {
        createAnewUser(user.getUid());
    }
    private void createAnewUser(String uid) {
        User_signup user = BuildNewuser();

        databaseReference.child(uid).setValue(user);
    }
    private User_signup BuildNewuser(){

        return new User_signup(

                getDisplayName(),

                getUserEmail(),
                getUserPhone(),
                getUserCity(),
                getUserPass(),

                new Date().getTime()

        );

    }


    public String getDisplayName() {

        return String.valueOf(signup_name);

    }

    public String getUserEmail() {

        return String.valueOf(signup_email);

    }
    public String getUserPhone() {

        return String.valueOf(signup_phone);

    }
    public String getUserCity() {

        return String.valueOf(signup_city);

    }
    public String getUserPass() {

        return String.valueOf(signup_password);

    }
}
