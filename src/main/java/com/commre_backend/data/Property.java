package com.commre_backend.data;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document("Property")
public class Property  {
    private String id;
    private String Property_Name;
    private ArrayList<Listing> ListingsOfProperty;
    private String Address1;
    private String Address2;
    private String State;
    private String City;

    public String getId() {
        return id;
    }


    public String getProperty_Name() {
        return Property_Name;
    }

    public void setProperty_Name(String property_Name) {
        Property_Name = property_Name;
    }

    public ArrayList<Listing> getListingsOfProperty() {
        return ListingsOfProperty;
    }

    public void setListingsOfProperty(ArrayList<Listing> listingsOfProperty) {
        ListingsOfProperty = listingsOfProperty;
    }
    public void updateListing(int id, String listing_Name, String listing_Date, boolean is_Active, double price){
        ListingsOfProperty.get(id-1).setListing_Name(listing_Name);
        ListingsOfProperty.get(id-1).setListing_Date(listing_Date);
        ListingsOfProperty.get(id-1).setIs_Active(is_Active);
        ListingsOfProperty.get(id-1).setPrice(price);
    }
    public void addListing(String listing_Name, String listing_Date, boolean is_Active, double price){
        Listing newListing = new Listing(ListingsOfProperty.size() +1, listing_Name,listing_Date,is_Active, price);
        ListingsOfProperty.add(newListing);
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Property(String property_Name, Listing listingsOfProperty, String address1, String address2, String state, String city) {
        ListingsOfProperty = new ArrayList<Listing>();
        Property_Name = property_Name;
        ListingsOfProperty.add(listingsOfProperty);
        Address1 = address1;
        Address2 = address2;
        State = state;
        City = city;
    }

    public Property() {
    }


}

