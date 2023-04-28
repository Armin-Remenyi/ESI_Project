package com.renting.candidacy;

import java.math.BigDecimal;
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

@RestController
public class CandidacyController
{
    private  List<Candidacy> candidacies =  new ArrayList<>(Arrays.asList(
        new Candidacy(1, 1, 3, BigDecimal.valueOf(80), LocalDate.of(2023, 1, 13), "Waiting"),
        new Candidacy(2, 2, 1, BigDecimal.valueOf(90), LocalDate.of(2023, 1, 13), "Accepted"),
        new Candidacy(3, 3, 3, BigDecimal.valueOf(25), LocalDate.of(2023, 1, 13), "Denied"),
        new Candidacy(4, 4, 5, BigDecimal.valueOf(100), LocalDate.of(2023, 1, 13), "Waiting"),
        new Candidacy(5, 5, 5, BigDecimal.valueOf(51), LocalDate.of(2023, 1, 13), "Waiting")
     ));
 
     @GetMapping("/candidacies")
     public List<Candidacy> getAllCandidacy()
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
