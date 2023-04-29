package com.esi.handoverservice.handovers.controller;

import java.time.LocalDate;
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

import com.esi.handoverservice.handovers.model.Handover;

@RestController
public class HandoverController
{
    private List<Handover> handovers =  new ArrayList<>(Arrays.asList(
        new Handover(1, LocalDate.of(2023, 1, 14), "yes", "yes", "yes", "Waiting", "Waiting")
     ));
 
     @GetMapping("/handovers")
     public List<Handover> getAllHandovers()
     {
         return handovers;
     }
 
     @GetMapping("/handovers/{id}")
     public Handover getHandover(@PathVariable Integer handoverid)
     {
         return handovers.stream().filter(c->c.getHandoverid().equals(handoverid)).findFirst().get();
     }
 
     @PostMapping("/handovers")
     public void addHandover(@RequestBody Handover handover)
     {
        handovers.add(handover);    
     }
 
     @PutMapping("/handovers/{id}")
     public void updateHandover(@RequestBody Handover handover, @PathVariable Integer handoverid)
     {
         for (int i = 0; i < handovers.size(); i++)
         {
            Handover c = handovers.get(i);
             if (c.getHandoverid().equals(handoverid)){
                handovers.set(i, handover);
             return;}
         }
     }
 
     @DeleteMapping("/handovers/{id}")
     public void deleteHandover(@PathVariable Integer handoverid)
     {
        handovers.removeIf(c->c.getHandoverid().equals(handoverid));
     }   
}
