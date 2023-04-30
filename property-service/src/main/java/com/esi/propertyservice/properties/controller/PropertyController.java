package com.esi.propertyservice.properties.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esi.propertyservice.properties.dto.PropertyDto;
import com.esi.propertyservice.properties.model.Property;
import com.esi.propertyservice.properties.service.PropertyService;


@RestController
@RequestMapping("/api")
public class PropertyController
{
    @Autowired
    private PropertyService propertyService;

    // private List<Property> properties =  new ArrayList<>(Arrays.asList(
    //     new Property(1, 20, "yes", "Neverland", 3, 1, "Street"),
    //     new Property(2, 40, "no", "Hereandthere", 7, 3, "None")
    //  ));
 
     @GetMapping("/properties")
     public List<PropertyDto> getAllProperties()
     {
        return propertyService.getAllProperties();
     }
 
     @GetMapping("/properties/{propertyid}")
     public Optional <PropertyDto> getProperty(@PathVariable Integer propertyid)
     {
        return propertyService.getProperty(propertyid);
     }
 
     @PostMapping("/properties")
     public void addProperty(@RequestBody PropertyDto propertyDto)
     {
        propertyService.addProperty(propertyDto);    
     }
 
     @PutMapping("/properties/{propertyid}")
     public void updateProperty(@RequestBody PropertyDto propertyDto, @PathVariable Integer propertyid)
     {
        propertyService.updateProperty(propertyid, propertyDto);
     }
 
     @DeleteMapping("/properties/{propertyid}")
     public void deleteProperty(@PathVariable Integer propertyid)
     {
        propertyService.deleteProperty(propertyid);
     }   
}
