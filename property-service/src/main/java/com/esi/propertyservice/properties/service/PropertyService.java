package com.esi.propertyservice.properties.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.esi.propertyservice.properties.dto.PropertyDto;

import com.esi.propertyservice.properties.model.Property;
import com.esi.propertyservice.properties.repository.PropertyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;
    
    @Autowired
    private WebClient.Builder webClientBuilder;

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

    public void deleteProperty(Integer propertyid) {
        propertyRepository.deleteById(propertyid);
    }
}
