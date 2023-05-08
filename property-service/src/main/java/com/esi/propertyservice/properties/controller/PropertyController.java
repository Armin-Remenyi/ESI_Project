package com.esi.propertyservice.properties.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esi.propertyservice.properties.dto.PropertyDto;
import com.esi.propertyservice.properties.service.PropertyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PropertyController
{
    @Autowired
    private PropertyService propertyService;
 
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
