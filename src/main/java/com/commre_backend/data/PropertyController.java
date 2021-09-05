package com.commre_backend.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@CrossOrigin(origins = "http://localhost:3000/newProperty")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class PropertyController {



    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    //getPropertiesController gets all the info from the database and returns it in a list.
    @GetMapping("/findAll")
    public List<Property> getPropertiesController() {
        return propertyService.getProperties();
    }

    // findPropertyController takes an id and returns that property and any listings attached to that property.
    @GetMapping("/findOne")
    @ResponseBody
    public Object findPropertyController(String id) {
        return  propertyService.findProperty(id);
    }
    // postPropertyController takes in all the parameters for creating a new list with a single associated listing.
    @GetMapping("/newProperty")
    //@ResponseBody
    @ResponseBody
    public Property postPropertyController(String property_Name, String address1, String address2, String state,
                                           String city, String listing_Name, String listing_Date, boolean is_Active, double price) {

        return propertyService.postProperty(property_Name,address1,address2,state,city,listing_Name,listing_Date,is_Active,price);
    }
//deleteOnePropertyController deletes a property based on id of the object.

    @GetMapping("/deleteById")
    @ResponseBody
    public String deleteOnePropertyController(String id) {

        return propertyService.deleteOneProperty(id);
    }

    //updatePropertyController takes in all the info of a proper along with its id and replaces the info in the database.
    @GetMapping("/update")
    @ResponseBody
    public Object updatePropertyController(String id, String property_Name, String address1, String address2, String state,
                                           String city, int listingId, String listing_Name, String listing_Date, boolean is_Active, double price) {

        return propertyService.updateProperty(id,property_Name,address1,address2,state,city,listingId,listing_Name,listing_Date,is_Active,price);
    }
    //newListingController takes the id of the property and creates a new listing in the property.
    @GetMapping("/addNewListing")
    @ResponseBody
    public Object newListingController(String id, String listing_Name, String listing_Date, boolean is_Active, double price){

        return propertyService.newListing(id,listing_Name,listing_Date,is_Active,price);
    }
     // I hope to never get this.
    @GetMapping("/error")
    public String somethingWentWrong() {
        return "That was not supposes to happen. Good luck finding the error!";
    }

}
