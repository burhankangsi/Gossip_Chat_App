package com.example.biddinginterface.Model;

import java.util.ArrayList;

public class SectionDataModelFragOngoing {
    private String headerTitle;

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle, int i) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModelFragOngoing> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModelFragOngoing> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

    private ArrayList<SingleItemModelFragOngoing> allItemsInSection;
    public SectionDataModelFragOngoing()
    {}

    public SectionDataModelFragOngoing (String headerTitle, ArrayList items_in_section)
    {
        this.headerTitle = headerTitle;
        this.allItemsInSection = items_in_section;
    }
}
