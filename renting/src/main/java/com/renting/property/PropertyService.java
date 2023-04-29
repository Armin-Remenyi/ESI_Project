package com.renting.property;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getAlProperties()
    {
        List<Property> properties = new ArrayList<>();
        propertyRepository.findAll().forEach(properties::add);
        return properties;
    }
    public Optional<Property> getProperty(Integer propertyid){
        return propertyRepository.findById(propertyid);
    }

    public void addProperty(Property property) {
        propertyRepository.save(property);
    }

    // To be solved by students
    public void updateProperty(Integer propertyid, Property property) {

    }

    // To be solved by students
    public void deleteProperty(Integer propertyid) {
        propertyRepository.deleteById(propertyid);
    }
}
