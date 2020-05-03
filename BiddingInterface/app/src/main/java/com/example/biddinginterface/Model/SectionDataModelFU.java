package com.example.biddinginterface.Model;

import java.util.ArrayList;

public class SectionDataModelFU {
    private String headerTitle;

    public String getHeaderTitle() {
        return headerTitle;
    }
    public SectionDataModelFU()
    {}

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModelFragUpcoming> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModelFragUpcoming> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

    private ArrayList<SingleItemModelFragUpcoming> allItemsInSection;

    public SectionDataModelFU(String title, ArrayList<SingleItemModelFragUpcoming> allItemsInSection)
    {
        this.headerTitle = title;
        this.allItemsInSection = allItemsInSection;
    }
}
