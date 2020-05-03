package com.example.biddinginterface.ViewHolder;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biddinginterface.Adapter.RecyclerView_Adapter_FragBest;
import com.example.biddinginterface.R;

import java.util.concurrent.TimeUnit;

public class RecyclerViewHolderFB extends RecyclerView.ViewHolder {
    public TextView tv_rv_holder_prod_name_best, tv_rv_holder_prod_price_best, tv_rv_holder_time_best;
    public ImageView iv_rv_holder_prod_img_best;

    public RecyclerViewHolderFB(@NonNull View itemView) {
        super(itemView);
        this.tv_rv_holder_prod_name_best = (TextView)itemView.findViewById(R.id.tv_prod_name_cardView);
        this.iv_rv_holder_prod_img_best = (ImageView)itemView.findViewById(R.id.iv_card_frag_best);
        this.tv_rv_holder_prod_price_best = (TextView)itemView.findViewById(R.id.tv_price_card_frag_best);
        this.tv_rv_holder_time_best = (TextView)itemView.findViewById(R.id.tv_time_cardView);
    }

}
