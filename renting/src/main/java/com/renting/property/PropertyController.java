package com.renting.property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PropertyController
{
    private List<Property> properties =  new ArrayList<>(Arrays.asList(
        new Property(1, 20, "yes", "Neverland", 3, 1, "Street"),
        new Property(2, 40, "no", "Hereandthere", 7, 3, "None")
     ));
 
     @GetMapping("/properties")
     public List<Property> getAllProperty()
     {
         return properties;
     }
 
     @GetMapping("/properties/{id}")
     public Property getProperty(@PathVariable Integer propertyid)
     {
         return properties.stream().filter(c->c.getPropertyid().equals(propertyid)).findFirst().get();
     }
 
     @PostMapping("/properties")
     public void addProperty(@RequestBody Property property)
     {
        properties.add(property);    
     }
 
     @PutMapping("/properties/{id}")
     public void updateProperty(@RequestBody Property property, @PathVariable Integer propertyid)
     {
         for (int i = 0; i < properties.size(); i++)
         {
            Property c = properties.get(i);
             if (c.getPropertyid().equals(propertyid)){
                properties.set(i, property);
             return;}
         }
     }
 
     @DeleteMapping("/properties/{id}")
     public void deleteProperty(@PathVariable Integer propertyid)
     {
        properties.removeIf(c->c.getPropertyid().equals(propertyid));
     }   
}
