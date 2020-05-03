package com.example.biddinginterface;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.example.biddinginterface.Adapter.RecyclerViewDataAdapterFO;
import com.example.biddinginterface.Adapter.RecyclerView_Adapter_FragBest;
import com.example.biddinginterface.Model.DataModelFragBest;
import com.example.biddinginterface.Model.SectionDataModelFragOngoing;
import com.example.biddinginterface.Model.SingleItemModelFragOngoing;

import java.util.ArrayList;


public class Frag_ongoing_home extends Fragment {
    private TextView tv_on_going;
    private RecyclerView rv_ongoing_home;

    public static final String[] TITLES = {"Full Sleaves", "Round Neck", "Half Sleaves", "Jeans", "Jacket", "Hood"};
    public static final Integer[] IMAGES = {R.drawable.fs_shirt, R.drawable.round_neck,
            R.drawable.half_sleeves, R.drawable.jeans, R.drawable.jacket, R.drawable.hood};
    public static final String[] prod_price_frag_ongoing = {"650", "380", "520", "800", "1250", "840"};
    private static String navigateFrom;  //String to get intent value
    public static String timeLeft;
    ArrayList<SectionDataModelFragOngoing> allSampleData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_frag_ongoing_home, container, false);
        tv_on_going = (TextView)view.findViewById(R.id.tv_home_ongoing_scroll);
        tv_on_going.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Bids_Main_Screen.class);
                startActivity(intent);
        allSampleData = new ArrayList<SectionDataModelFragOngoing>();

            }
        });
        // initViews();
        // Set back icon on  activity
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Get Intent value in string
        navigateFrom = getActivity().getIntent().getStringExtra("navigateFrom");

        rv_ongoing_home = (RecyclerView) view.findViewById(R.id.my_recycler_view1);
        rv_ongoing_home.setHasFixedSize(true);

        // Set Recycler View type according to Intent value
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Best Deals Available (Horizontal)");
        rv_ongoing_home.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        populateRecyclerView();

        return view;
    }

    private void populateRecyclerView() {
        //for (int z = 1; z <= 5; z++) {
        //  SectionDataModelFragOngoing dataModel = new SectionDataModelFragOngoing();
        // dataModel.setHeaderTitle("Section",+z);
        ArrayList<SingleItemModelFragOngoing> arrayList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            arrayList.add(new SingleItemModelFragOngoing(TITLES[i], IMAGES[i], prod_price_frag_ongoing[i]));
            // startTimer(30);

        }
        RecyclerViewDataAdapterFO adapter = new RecyclerViewDataAdapterFO(getActivity(), allSampleData);
        rv_ongoing_home.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rv_ongoing_home.setAdapter(adapter);  // set adapter on recycler view
        adapter.notifyDataSetChanged();  // Notify the adapter
   // }
    }



//    private void startTimer(int i) {
//
//    }

//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case android.R.id.home:
//                finish();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}