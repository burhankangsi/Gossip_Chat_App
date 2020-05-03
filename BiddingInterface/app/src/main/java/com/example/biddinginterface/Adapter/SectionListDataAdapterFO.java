package com.example.biddinginterface.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biddinginterface.Model.DataModelFragBest;
import com.example.biddinginterface.Model.SingleItemModelFragOngoing;
import com.example.biddinginterface.R;
import com.example.biddinginterface.ViewHolder.RecyclerViewHolderFB;

import java.util.ArrayList;

public class SectionListDataAdapterFO extends RecyclerView.Adapter<SectionListDataAdapterFO.SingleItemRowHolder> {
    private ArrayList<SingleItemModelFragOngoing> itemsList;
    private Context mContext;

    public SectionListDataAdapterFO(Context mContext, ArrayList<SingleItemModelFragOngoing> singleSectionItems) {
        this.itemsList = singleSectionItems;
        this.mContext = mContext;
}

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_card_fo, null);
        SingleItemRowHolder singleItemRowHolder = new SingleItemRowHolder(view);
        return singleItemRowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SectionListDataAdapterFO.SingleItemRowHolder holder, int position) {
        // final DataModelFragBest modelFragBest = arrayList.get(position);
        SingleItemModelFragOngoing singleItem = itemsList.get(position);
        SingleItemRowHolder mainHolder = (SingleItemRowHolder) holder;
        Bitmap image = BitmapFactory.decodeResource(mContext.getResources(), singleItem.getProd_img_frag_ongoing());
        mainHolder.tvProdName.setText(singleItem.getProdName_frg_ongoing());
        mainHolder.tvPrice.setText(singleItem.getProd_price_frag_ongoing());
        mainHolder.itemImage.setImageBitmap(image);


    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size():0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvProdName, tvPrice;
        protected ImageView itemImage;

        public SingleItemRowHolder(View view) {
            super(view);
            this.tvProdName = (TextView) view.findViewById(R.id.tv_prod_name_cardView_fo);
            this.tvPrice = (TextView) view.findViewById(R.id.tv_price_card_frag_ongoing);
            this.itemImage = (ImageView) view.findViewById(R.id.iv_card_frag_ongoing);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), tvProdName.getText(), Toast.LENGTH_SHORT);
                }
            });
        }
    }
}
