package com.example.biddinginterface.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biddinginterface.Frag_best_home;
import com.example.biddinginterface.Model.DataModelFragBest;
import com.example.biddinginterface.R;
import com.example.biddinginterface.ViewHolder.RecyclerViewHolderFB;

import java.util.ArrayList;

public class RecyclerView_Adapter_FragBest extends RecyclerView.Adapter<RecyclerViewHolderFB> {
    // RecyclerView will extend to recycler view adapter
    private ArrayList<DataModelFragBest> arrayList;
    private Context context;
    public RecyclerView_Adapter_FragBest(Context context, ArrayList<DataModelFragBest> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerViewHolderFB onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This method will inflate the custom layout and return as view holder
        LayoutInflater mInflator = LayoutInflater.from(parent.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflator.inflate(R.layout.list__single__card_fb,
                parent, false);
        RecyclerViewHolderFB listHolder = new RecyclerViewHolderFB(mainGroup);
        return listHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderFB holder, int position) {
        final DataModelFragBest modelFragBest = arrayList.get(position);
        RecyclerViewHolderFB mainHolder = (RecyclerViewHolderFB)holder;
        Bitmap image = BitmapFactory.decodeResource(context.getResources(), modelFragBest.getProd_img_frag_best());
        // Setting product name, price and time
        mainHolder.tv_rv_holder_prod_name_best.setText(modelFragBest.getProdName_frag_best());
        mainHolder.tv_rv_holder_prod_price_best.setText(modelFragBest.getProd_price_frag_best());
        mainHolder.iv_rv_holder_prod_img_best.setImageBitmap(image);
        mainHolder.tv_rv_holder_time_best.setText(Frag_best_home.timeLeft);  // set text time

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size():0);
    }

}
