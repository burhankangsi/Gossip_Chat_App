package com.example.biddinginterface;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.biddinginterface.ui.CustomerService;
import com.example.biddinginterface.ui.gallery.MyPurchases;
import com.example.biddinginterface.ui.home.MyBids;
import com.example.biddinginterface.ui.send.Wishlist;
import com.example.biddinginterface.ui.share.Settings;
import com.example.biddinginterface.ui.slideshow.MyProfile;
import com.example.biddinginterface.ui.tools.TransactionHistory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class Home_Drawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //private AppBarConfiguration mAppBarConfiguration;
    private View navHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navHeader = navigationView.getHeaderView(0);

        // Loading Profile Image
        ImageView profileImage = navHeader.findViewById(R.id.imageView);
        Glide.with(this).load("http://www.androiddeft.com/wp-content/uploads/2017/11/abhishek.jpg")
                .apply(RequestOptions.circleCropTransform())
                .thumbnail(0.5f).into(profileImage);

        // Loading Background Image
//        ImageView navBackground = navHeader.findViewById(R.id.xyz_bg_img);
//        Glide.with(this).load("https://www.linkOfBgImg.jpg")
//                .thumbnail(0.5f).into(navBackground);

        // Select Home by Default
        navigationView.setCheckedItem(R.id.nav_my_home);
        Fragment fragment = new HomeFragment();
        displaySelectedFragment1(fragment);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_my_bids, R.id.nav_my_purchases, R.id.nav_my_profile,
//                R.id.nav_transaction_history, R.id.nav_settings, R.id.nav_wishlist, R.id.nav_cust_care)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void displaySelectedFragment1(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag1_nav_drawer, fragment);
        fragmentTransaction.commit();
    }

    private void displaySelectedFragment2(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag2_nav_drawer, fragment);
        fragmentTransaction.commit();
    }
    private void displaySelectedFragment3(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag3_nav_drawer, fragment);
        fragmentTransaction.commit();
    }
    private void displaySelectedFragment4(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag4_nav_drawer, fragment);
        fragmentTransaction.commit();
    }
    private void displaySelectedFragment5(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag5_nav_drawer, fragment);
        fragmentTransaction.commit();
    }
    private void displaySelectedFragment6(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag6_nav_drawer, fragment);
        fragmentTransaction.commit();
    }
    private void displaySelectedFragment7(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag7_nav_drawer, fragment);
        fragmentTransaction.commit();
    }

    private void displaySelectedFragment9(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag9_nav_drawer, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home__drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
    }
        if (id == R.id.action_logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Handle navigation view item clicks here.
        int id = menuItem.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_my_home) {
            fragment = new HomeFragment();
            displaySelectedFragment1(fragment);
            // OpenRecyclerViewActivity("horizontal");
        } else if (id == R.id.nav_my_bids) {
            fragment = new MyBids();
            displaySelectedFragment2(fragment);

        } else if (id == R.id.nav_my_purchases) {
            fragment = new MyPurchases();
            displaySelectedFragment3(fragment);

        } else if (id == R.id.nav_my_profile) {
            fragment = new MyProfile();
            displaySelectedFragment4(fragment);

        } else if (id == R.id.nav_trans_history) {
            fragment = new TransactionHistory();
            displaySelectedFragment5(fragment);

        } else if (id == R.id.nav_settings) {
            fragment = new Settings();
            displaySelectedFragment6(fragment);

        } else if (id == R.id.nav_wishlist) {
            fragment = new Wishlist();
            displaySelectedFragment7(fragment);

        } else if (id == R.id.nav_share_n_earn) {
            // Display share via dialog
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Install and Register on Nimpat");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Hey Buddy, I have found an amazing app for online auctions: http://androiddeft.com");
            startActivity(Intent.createChooser(sharingIntent, "Share Via"));

        } else if (id == R.id.nav_contact_us) {
            fragment = new CustomerService();
            displaySelectedFragment9(fragment);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    private void OpenRecyclerViewActivity(String horizontal) {
//        Intent intent = new Intent(Home_Drawer.this, Frag_best_home.class);
//        intent.putExtra("horizontal", horizontal);
//        startActivity(intent);
//    }

}

