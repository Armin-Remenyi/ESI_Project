package com.esi.propertyservice.properties.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.esi.propertyservice.properties.model.Property;

public interface PropertyRepository extends CrudRepository<Property, Integer>{
    
}
