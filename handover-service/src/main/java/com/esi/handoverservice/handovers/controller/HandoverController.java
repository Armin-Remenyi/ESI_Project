package com.esi.handoverservice.handovers.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.esi.handoverservice.handovers.dto.HandoverDto;
import com.esi.handoverservice.handovers.model.Handover;
import com.esi.handoverservice.handovers.service.HandoverService;

@RestController
@RequestMapping("/api")
public class HandoverController
{
    @Autowired
    private HandoverService handoverService;

    private List<Handover> handovers =  new ArrayList<>(Arrays.asList(
        new Handover(1, LocalDate.of(2023, 1, 14), "yes", "yes", "yes", "Waiting", "Waiting")
     ));
 
     @GetMapping("/handovers")
     public List<HandoverDto> getAllHandovers()
     {
         return handoverService.getAllHandovers();
     }
 
     @GetMapping("/handovers/{handoverid}")
     public Optional <HandoverDto> getHandover(@PathVariable Integer handoverid)
     {
         return handoverService.getHandover(handoverid);
     }
 
     @PostMapping("/handovers")
     public void addHandover(@RequestBody HandoverDto handoverDto)
     {
        handoverService.addHandover(handoverDto);    
     }
 
     @PutMapping("/handovers/{handoverid}")
     public void updateHandover(@RequestBody HandoverDto handoverDto, @PathVariable Integer handoverid)
     {
         handoverService.updateHandover(handoverid, handoverDto);
     }
 
     @DeleteMapping("/handovers/{handoverid}")
     public void deleteHandover(@PathVariable Integer handoverid)
     {
        handoverService.deleteHandover(handoverid);
     }   
}
