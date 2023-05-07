package com.esi.candidacyservice.candidacies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esi.candidacyservice.candidacies.dto.CandidacyDto;
import com.esi.candidacyservice.candidacies.service.CandidacyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CandidacyController {
    @Autowired
    private CandidacyService candidacyService;

    @GetMapping("/candidacies")
    public List<CandidacyDto> getAllCandidacies() {
        return candidacyService.getAllCandidacies();
    }

    @GetMapping("/candidacies/listing/{listingid}")
    public List<CandidacyDto> getAllCandidaciesByListingId(@PathVariable Integer listingid) {
        return candidacyService.getAllCandidaciesByListingId(listingid);
    }

    @GetMapping("/candidacies/{candidacyid}")
    public Optional<CandidacyDto> getCandidacy(@PathVariable Integer candidacyid) {
        return candidacyService.getCandidacy(candidacyid);
    }

    @PostMapping("/candidacies")
    public void addCandidacy(@RequestBody CandidacyDto candidacyDto) {
        candidacyService.addCandidacy(candidacyDto);
    }

    @PutMapping("/candidacies/{candidacyid}")
    public void updateCandidacy(@RequestBody CandidacyDto candidacyDto, @PathVariable Integer candidacyid) {
        candidacyService.updateCandidacy(candidacyid, candidacyDto);
    }

    @DeleteMapping("/candidacies/{candidacyid}")
    public void deleteCandidacy(@PathVariable Integer candidacyid) {
        candidacyService.deleteContract(candidacyid);
    }
}
