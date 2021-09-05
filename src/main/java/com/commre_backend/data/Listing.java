package com.commre_backend.data;


import java.util.Date;
import java.util.List;

public class Listing {
    private int id;
    private String Listing_Name;
    private String Listing_Date;
    private boolean Is_Active;

    private double Price;
    public Listing(){}

    public Listing(int id, String listing_Name, String listing_Date, boolean is_Active, double price) {
        this.id = id;
        Listing_Name = listing_Name;
        Listing_Date = listing_Date;
        Is_Active = is_Active;
        Price = price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListing_Name() {
        return Listing_Name;
    }

    public void setListing_Name(String listing_Name) {
        Listing_Name = listing_Name;
    }

    public String getListing_Date() {
        return Listing_Date;
    }

    public void setListing_Date(String listing_Date) {
        Listing_Date = listing_Date;
    }

    public boolean isIs_Active() {
        return Is_Active;
    }

    public void setIs_Active(boolean is_Active) {
        Is_Active = is_Active;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

}
