package com.esi.handoverservice.handovers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esi.handoverservice.handovers.dto.HandoverDto;
import com.esi.handoverservice.handovers.service.HandoverService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class HandoverController
{
    @Autowired
    private HandoverService handoverService;
 
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
     public Integer addHandover(@RequestBody HandoverDto handoverDto) {
        return handoverService.addHandover(handoverDto);
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
