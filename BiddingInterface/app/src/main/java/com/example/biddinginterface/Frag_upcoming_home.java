package com.example.biddinginterface;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biddinginterface.Adapter.RecyclerViewDataAdapterFU;
import com.example.biddinginterface.Model.SectionDataModelFU;

import java.util.ArrayList;


public class Frag_upcoming_home extends Fragment {
    private TextView tv_upcoming;
    private Button btn_sort_home_frag;
    private RecyclerView rv_upcoming_home;
    ArrayList<SectionDataModelFU> allSampleData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_frag_upcoming_home, container, false);
        tv_upcoming = (TextView)view.findViewById(R.id.tv_home_upcoming_scroll);
        btn_sort_home_frag = (Button)view.findViewById(R.id.btn_sort);
        allSampleData = new ArrayList<SectionDataModelFU>();

        tv_upcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_sort_home_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        populateView();
        rv_upcoming_home = (RecyclerView)view.findViewById(R.id.my_recycler_view3);
        rv_upcoming_home.setHasFixedSize(true);
        RecyclerViewDataAdapterFU adapter = new RecyclerViewDataAdapterFU(getActivity(), allSampleData);
        rv_upcoming_home.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rv_upcoming_home.setAdapter(adapter);

        return view;
    }

    private void populateView() {

    }


}
