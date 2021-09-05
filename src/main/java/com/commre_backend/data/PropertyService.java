package com.commre_backend.data;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getProperties() {
        List<Property> list = propertyRepository.findAll();
        return list;
    }
    public Object findProperty(String id){
        Optional<Property> returnedProperty = propertyRepository.findById(id);
        if (returnedProperty.isEmpty()) {
            return new Property();
        }
        return returnedProperty;
    }
    public Property postProperty(String property_Name, String address1, String address2, String state,
                                 String city, String listing_Name, String listing_Date, boolean is_Active, double price){
        Listing newList = new Listing(1, listing_Name, listing_Date, is_Active, price);

        //http://localhost:8080/newProperty?property_Name=Walt%20Disney%20Concert%20Hall&address1=135%20North%20Grand%20Avenue&address2=%20&state=CA&city=Los%20Angels&listing_Name=Walt%20Disney&listing_Date=6/5/2000&is_Active=true&price=1244907.07257068

        Property newProperty = new Property(property_Name, newList, address1, address2, state, city);
        propertyRepository.insert(newProperty);
        return newProperty;
    }
    public String deleteOneProperty(String id){
        propertyRepository.deleteById(id);
        return "deleted property";
    }
    public Object updateProperty(String id, String property_Name, String address1, String address2, String state,
                                 String city, int listingId, String listing_Name, String listing_Date, boolean is_Active, double price){
        Optional<Property> oneToUpdate = propertyRepository.findById(id);
        if (oneToUpdate.isEmpty()) {
            return "not found";
        }

        oneToUpdate.get().setProperty_Name(property_Name);
        oneToUpdate.get().setAddress1(address1);
        oneToUpdate.get().setAddress2(address2);
        oneToUpdate.get().setState(state);
        oneToUpdate.get().setCity(city);
        oneToUpdate.get().updateListing(listingId, listing_Name, listing_Date, is_Active, price);

        propertyRepository.save(oneToUpdate.get());
        return oneToUpdate;
    }
    public Object newListing(String id, String listing_Name, String listing_Date, boolean is_Active, double price){
        //http://localhost:8080/addNewListing?id=612d9e72643bbf2603e7bd81&listing_Name=Abu%20Dhabi%20Investment&listing_Date=4/15/2012&is_Active=true&price=97456342
        Optional<Property> oneToUpdate = propertyRepository.findById(id);
        if (oneToUpdate.isEmpty()) {
            return "not found";
        }
        oneToUpdate.get().addListing(listing_Name,listing_Date,is_Active,price);
        propertyRepository.save(oneToUpdate.get());
        return oneToUpdate;
    }


}
