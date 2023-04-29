package com.esi.candidacyservice.candidacys.controller;

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

import com.esi.Candidacyservice.candidacies.model.Candidacy;

@RestController
public class CandidacyController
{
    private List<Candidacy> candidacies =  new ArrayList<>(Arrays.asList(
        new Candidacy(1, LocalDate.of(2023, 1, 14), "yes", "yes", "yes", "Waiting", "Waiting")
     ));
 
     @GetMapping("/candidacies")
     public List<Candidacy> getAllCandidaciess()
     {
         return candidacies;
     }
 
     @GetMapping("/candidacies/{id}")
     public Candidacy getCandidacy(@PathVariable Integer candidacyid)
     {
         return candidacies.stream().filter(c->c.getCandidacyid().equals(candidacyid)).findFirst().get();
     }
 
     @PostMapping("/candidacies")
     public void addCandidacy(@RequestBody Candidacy candidacy)
     {
        candidacies.add(candidacy);    
     }
 
     @PutMapping("/candidacies/{id}")
     public void updateCandidacy(@RequestBody Candidacy candidacy, @PathVariable Integer candidacyid)
     {
         for (int i = 0; i < candidacies.size(); i++)
         {
            Candidacy c = candidacies.get(i);
             if (c.getCandidacyid().equals(candidacyid)){
                candidacies.set(i, candidacy);
             return;}
         }
     }
 
     @DeleteMapping("/candidacies/{id}")
     public void deleteCandidacy(@PathVariable Integer candidacyid)
     {
        candidacies.removeIf(c->c.getCandidacyid().equals(candidacyid));
     }   
}
