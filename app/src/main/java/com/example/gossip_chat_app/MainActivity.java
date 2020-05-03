package com.example.gossip_chat_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gossip_chat_app.Adapter.MyFragmentPagerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mauth;
    ViewPager mviewPager;
    MyFragmentPagerAdapter mFragmentPagerAdapter;
    TabLayout mtabLayout;
    DatabaseReference mDatabaseReference;

    //Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mauth = FirebaseAuth.getInstance();

        mviewPager = (ViewPager) findViewById(R.id.viewPager);

        //---ADDING ADAPTER FOR FRAGMENTS IN VIEW PAGER----
        mFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mviewPager.setAdapter(mFragmentPagerAdapter);

        //---SETTING TAB LAYOUT WITH VIEW PAGER
        mtabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mtabLayout.setupWithViewPager(mviewPager);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("users");
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Really Exit ??");
        builder.setTitle("Exit");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok",new MainActivity.MyListener());
        builder.setNegativeButton("Cancel",null);
        builder.show();
    }

    public class MyListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user=mauth.getCurrentUser();
        if(user==null){
            startfn();
        }
        else{
            //---IF LOGIN , ADD ONLINE VALUE TO TRUE---
            mDatabaseReference.child(user.getUid()).child("online").setValue("true");

        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        /* //-----for disabling online function when appliction runs in background----
        FirebaseUser user=mauth.getCurrentUser();
        if(user!=null){
            mDatabaseReference.child(user.getUid()).child("online").setValue(ServerValue.TIMESTAMP);
        }
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId()==R.id.settings){
            Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.allUsers){
            Intent intent=new Intent(MainActivity.this,UserActivity.class);
            startActivity(intent);
        }

        //---LOGGING OUT AND ADDING TIME_STAMP----
        if(item.getItemId()==R.id.logout){
            mDatabaseReference.child(mauth.getCurrentUser().getUid()).child("online").setValue(ServerValue.TIMESTAMP).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){

                        FirebaseAuth.getInstance().signOut();
                        startfn();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Try again..", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        return true;
    }

    //--OPENING LOGIN ACTIVITY--
    private void startfn(){
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

}

