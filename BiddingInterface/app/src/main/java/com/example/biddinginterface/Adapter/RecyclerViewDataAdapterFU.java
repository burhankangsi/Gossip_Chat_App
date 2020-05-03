package com.example.biddinginterface.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biddinginterface.Model.SectionDataModelFU;
import com.example.biddinginterface.R;

import java.util.ArrayList;

public class RecyclerViewDataAdapterFU extends RecyclerView.Adapter<RecyclerViewDataAdapterFU.ItemRowHolder> {

    private ArrayList<SectionDataModelFU> dataList;
    private Context mContext;

    public RecyclerViewDataAdapterFU (Context context, ArrayList<SectionDataModelFU> dataList)
    {
        this.dataList = dataList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerViewDataAdapterFU.ItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_frag_upcoming, null);
        ItemRowHolder holder = new ItemRowHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewDataAdapterFU.ItemRowHolder holder, int position) {
        final String sectionName = dataList.get(position).getHeaderTitle();
        ArrayList singleSectionItems = dataList.get(position).getAllItemsInSection();
        holder.title.setText(sectionName);

        SectionListDataAdapterFU itemListDataAdapter = new SectionListDataAdapterFU(mContext, singleSectionItems);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(itemListDataAdapter);

    }

    @Override
    public int getItemCount() {
        return null != dataList ? dataList.size():0;
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder{
        protected TextView title;
        protected RecyclerView recyclerView;

        public ItemRowHolder(@NonNull View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.tv_list_above_card_view_fu);
            this.recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_list_item_upcoming_frag);
        }
    }
}
