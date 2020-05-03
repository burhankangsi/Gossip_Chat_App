package com.example.biddinginterface;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.biddinginterface.Adapter.RecyclerView_Adapter_FragBest;
import com.example.biddinginterface.Model.DataModelFragBest;
import com.example.biddinginterface.ViewHolder.RecyclerViewHolderFB;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Frag_best_home extends Fragment {
    private TextView tv_best_home;
    private Button btn_sort_home_frag;
    private static RecyclerView recyclerView;

    // String and integer array for recycler view items
    public static final String[] TITLES = {"Full Sleaves", "Round Neck", "Half Sleaves", "Jeans", "Jacket", "Hood"};
    public static final Integer[] IMAGES = {R.drawable.fs_shirt, R.drawable.round_neck,
            R.drawable.half_sleeves, R.drawable.jeans, R.drawable.jacket, R.drawable.hood};
    public static final String[] prod_price_frag_best = {"650", "380", "520", "800", "1250", "840"};
    private static String navigateFrom;  //String to get intent value
    public static String timeLeft;

    //textEntered mCallBack;
//    public interface textEntered {
//        public void setValue(String editextvalue);
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_best_home, container, false);
        tv_best_home = (TextView)view.findViewById(R.id.tv_home_best_scroll);
        btn_sort_home_frag = (Button)view.findViewById(R.id.btn_sort);
        btn_sort_home_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sorting Logic
            }
        });
        tv_best_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Bids_Main_Screen.class);
                startActivity(intent);
            }
        });

        // initViews();
        // Set back icon on  activity
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Get Intent value in string
        navigateFrom = getActivity().getIntent().getStringExtra("navigateFrom");

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view1);
        recyclerView.setHasFixedSize(true);

        // Set Recycler View type according to Intent value
        if (navigateFrom.equals("horizontal"))
        {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Best Deals Available (Horizontal)");
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL, false));
        }
        else {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Best Deals Available (Vertical)");
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        }
        populateRecyclerView();
        return view;

    }

//    // Initialize the view
//    private void initViews() {
//
//    }
    // populate the list view by adding data to arraylist
    private void populateRecyclerView()
    {
        ArrayList<DataModelFragBest> arrayList = new ArrayList<>();
        for (int i=0; i<TITLES.length; i++) {
            arrayList.add(new DataModelFragBest(TITLES[i], IMAGES[i], prod_price_frag_best[i], timeLeft));
            startTimer(30);

        }
        RecyclerView_Adapter_FragBest adapter = new RecyclerView_Adapter_FragBest(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);  // set adapter on recycler view
        adapter.notifyDataSetChanged();  // Notify the adapter
    }

    private void startTimer(int i) {
        final CountDownTimer countDownTimer = new CountDownTimer(90000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                // Convert milliseconds into hours, minutes and seconds
                timeLeft = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis)-
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis)-
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

            }

            @Override
            public void onFinish() {
                timeLeft = "Time's Up !!";

            }
        }.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_my_home:
                getActivity().finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//    }
}
