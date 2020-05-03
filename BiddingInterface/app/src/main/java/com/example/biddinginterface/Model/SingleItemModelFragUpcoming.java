package com.example.biddinginterface.Model;

public class SingleItemModelFragUpcoming {
    public String getProd_price_frag_ongoing() {
        return prod_price_frag_ongoing;
    }

    public void setProd_price_frag_ongoing(String prod_price_frag_ongoing) {
        this.prod_price_frag_ongoing = prod_price_frag_ongoing;
    }

    public String getProdName_frg_ongoing() {
        return prodName_frg_ongoing;
    }

    public void setProdName_frg_ongoing(String prodName_frg_ongoing) {
        this.prodName_frg_ongoing = prodName_frg_ongoing;
    }

    public int getProd_img_frag_ongoing() {
        return prod_img_frag_ongoing;
    }

    public void setProd_img_frag_ongoing(int prod_img_frag_ongoing) {
        this.prod_img_frag_ongoing = prod_img_frag_ongoing;
    }

    private String prod_price_frag_ongoing ,prodName_frg_ongoing;
    private int prod_img_frag_ongoing;

    public SingleItemModelFragUpcoming(String prodName_fo, int prod_img_fo, String prod_price_fo)
    {
        this.prodName_frg_ongoing = prodName_fo;
        this.prod_img_frag_ongoing = prod_img_fo;
        this.prod_price_frag_ongoing = prod_price_fo;
    }

}
