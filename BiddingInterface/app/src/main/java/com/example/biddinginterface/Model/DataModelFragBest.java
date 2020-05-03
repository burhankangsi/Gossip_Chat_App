package com.example.biddinginterface.Model;

import android.content.Intent;

public class DataModelFragBest {
    private String prodName_frag_best, time_frag_best;
    private String prod_price_frag_best;
    private int prod_img_frag_best;

    public DataModelFragBest(String prodName_fb, int prod_img_fb, String prod_price_fb, String time_fb)
    {
        this.prodName_frag_best = prodName_fb;
        this.prod_img_frag_best = prod_img_fb;
        this.prod_price_frag_best = prod_price_fb;
        this.time_frag_best = time_fb;
    }

    public String getProdName_frag_best() {
        return prodName_frag_best;
    }

    public void setProdName_frag_best(String prodName_frag_best) {
        this.prodName_frag_best = prodName_frag_best;
    }

    public String getTime_frag_best() {
        return time_frag_best;
    }

    public void setTime_frag_best(String time_frag_best) {
        this.time_frag_best = time_frag_best;
    }

    public String getProd_price_frag_best() {
        return prod_price_frag_best;
    }

    public void setProd_price_frag_best(String prod_price_frag_best) {
        this.prod_price_frag_best = prod_price_frag_best;
    }

    public int getProd_img_frag_best() {
        return prod_img_frag_best;
    }

    public void setProd_img_frag_best(int prod_img_frag_best) {
        this.prod_img_frag_best = prod_img_frag_best;
    }


}
