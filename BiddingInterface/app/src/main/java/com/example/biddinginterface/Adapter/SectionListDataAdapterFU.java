package com.example.biddinginterface.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biddinginterface.Model.SingleItemModelFragOngoing;
import com.example.biddinginterface.Model.SingleItemModelFragUpcoming;
import com.example.biddinginterface.R;

import java.util.ArrayList;

public class SectionListDataAdapterFU extends RecyclerView.Adapter <SectionListDataAdapterFU.SingleItemRowHolder>{
    private ArrayList<SingleItemModelFragUpcoming> itemsList;
    private Context mContext;

    public SectionListDataAdapterFU(Context mContext, ArrayList<SingleItemModelFragUpcoming> singleSectionItems) {
        this.itemsList = singleSectionItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_card_fu, null);
        SectionListDataAdapterFU.SingleItemRowHolder singleItemRowHolder = new SectionListDataAdapterFU.SingleItemRowHolder(view);
        return singleItemRowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SectionListDataAdapterFU.SingleItemRowHolder holder, int position) {
        SingleItemModelFragUpcoming singleItem = itemsList.get(position);
        SingleItemRowHolder mainHolder = (SingleItemRowHolder) holder;
        Bitmap image = BitmapFactory.decodeResource(mContext.getResources(), singleItem.getProd_img_frag_ongoing());
        mainHolder.tvProdName.setText(singleItem.getProdName_frg_ongoing());
        mainHolder.tvPrice.setText(singleItem.getProd_price_frag_ongoing());
        mainHolder.imageView.setImageBitmap(image);
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size():0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvProdName, tvPrice;
        protected ImageView imageView;

        public SingleItemRowHolder(@NonNull View itemView) {
            super(itemView);
            this.tvProdName = (TextView) itemView.findViewById(R.id.tv_prod_name_cardView_fu);
            this.tvPrice = (TextView) itemView.findViewById(R.id.tv_price_card_frag_upcoming);
            this.imageView = (ImageView) itemView.findViewById(R.id.iv_card_frag_upcoming);
        }
    }
}
