package com.esi.candidacyservice.candidacies.controller;

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

import com.esi.candidacyservice.candidacies.model.Candidacy;

import com.esi.candidacyservice.candidacies.dto.CandidacyDto;
import com.esi.candidacyservice.candidacies.service.CandidacyService;

@RestController
@RequestMapping("/api")
public class CandidacyController
{
    @Autowired
    private CandidacyService candidacyService;

    // private List<Candidacy> candidacies =  new ArrayList<>(Arrays.asList(
    //     new Candidacy(1, 3, "House", LocalDate.of(2023, 1, 14), "Waiting")
    //  ));
 
     @GetMapping("/candidacies")
     public List<CandidacyDto> getAllCandidacies()
     {
        return candidacyService.getAllCandidacies();
     }
 
     @GetMapping("/candidacies/{candidacyid}")
     public Optional <CandidacyDto> getCandidacy(@PathVariable Integer candidacyid)
     {
        return candidacyService.getCandidacy(candidacyid);
     }
 
     @PostMapping("/candidacies")
     public void addCandidacy(@RequestBody CandidacyDto candidacyDto)
     {
        candidacyService.addCandidacy(candidacyDto);    
     }
 
     @PutMapping("/candidacies/{candidacyid}")
     public void updateCandidacy(@RequestBody CandidacyDto candidacyDto, @PathVariable Integer candidacyid)
     {
        candidacyService.updateCandidacy(candidacyid, candidacyDto);   
     }
 
     @DeleteMapping("/candidacies/{candidacyid}")
     public void deleteCandidacy(@PathVariable Integer candidacyid)
     {
        candidacyService.deleteContract(candidacyid);
     }   
}
