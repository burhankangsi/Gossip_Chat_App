package com.example.biddinginterface.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biddinginterface.Model.SectionDataModelFragOngoing;
import com.example.biddinginterface.Model.SingleItemModelFragOngoing;
import com.example.biddinginterface.R;

import java.util.ArrayList;

public class RecyclerViewDataAdapterFO extends RecyclerView.Adapter<RecyclerViewDataAdapterFO.ItemRowHolderFragFO>{
    private ArrayList<SectionDataModelFragOngoing> dataList;
    private Context mContext;

    public RecyclerViewDataAdapterFO(Context context, ArrayList<SectionDataModelFragOngoing> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerViewDataAdapterFO.ItemRowHolderFragFO onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_frag_ongoing, null);
        ItemRowHolderFragFO itemHolder = new ItemRowHolderFragFO(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewDataAdapterFO.ItemRowHolderFragFO holder, int position) {
        final String sectionName = dataList.get(position).getHeaderTitle();
        ArrayList singleSectionItems = dataList.get(position).getAllItemsInSection();
        holder.itemTitle.setText(sectionName);

        SectionListDataAdapterFO itemListDataAdapter = new SectionListDataAdapterFO(mContext, singleSectionItems);
        holder.recycler_view_list.setHasFixedSize(true);
        holder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.recycler_view_list.setAdapter(itemListDataAdapter);


    }



    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolderFragFO extends RecyclerView.ViewHolder {
        protected TextView itemTitle;
        protected RecyclerView recycler_view_list;

        public ItemRowHolderFragFO(@NonNull View itemView) {
            super(itemView);
            this.itemTitle = (TextView)itemView.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) itemView.findViewById(R.id.recycler_view_adapter_fo);
        }
    }
}
