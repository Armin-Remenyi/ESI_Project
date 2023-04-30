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

    public List<PropertyDto> getAllProperties(){
        List<Property> properties =  new ArrayList<>();
        propertyRepository.findAll().forEach(properties::add);
        return properties.stream().map(this::mapToPropertyDto).toList();
        }
            private PropertyDto mapToPropertyDto(Property property){
                    return PropertyDto.builder()
                            .propertyid(property.getPropertyid())
                            .size(property.getSize())
                            .balcony(property.getBalcony())
                            .address(property.getAddress())
                            .floor(property.getFloor())
                            .rooms(property.getRooms())
                            .parking(property.getParking())
                            .build();
                }
                public Optional<PropertyDto> getProperty(Integer propertyid){
                Optional<Property> property = propertyRepository.findById(propertyid);
                return property.map(this::mapToPropertyDto);
            }
    
            public void addProperty(PropertyDto propertyDto) {
                Property property = Property.builder()
                .propertyid(propertyDto.getPropertyid())
                .size(propertyDto.getSize())
                .balcony(propertyDto.getBalcony())
                .address(propertyDto.getAddress())
                .floor(propertyDto.getFloor())
                .rooms(propertyDto.getRooms())
                .parking(propertyDto.getParking())
                .build();
                propertyRepository.save(property);
            log.info("Property {} is added to the Database", property.getPropertyid());
            }
    
            public void updateProperty(Integer propertyid, PropertyDto propertyDto) {
                Property property = Property.builder()
                .propertyid(propertyDto.getPropertyid())
                .size(propertyDto.getSize())
                .balcony(propertyDto.getBalcony())
                .address(propertyDto.getAddress())
                .floor(propertyDto.getFloor())
                .rooms(propertyDto.getRooms())
                .parking(propertyDto.getParking())
                .build();
            propertyRepository.save(property);
            log.info("Property {} is updated", property.getPropertyid());
            }
    
            public void deleteProperty(Integer propertyid) {
                propertyRepository.deleteById(propertyid);
            log.info("A Property has been deleted");
            }
};
