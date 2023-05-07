package com.renting.candidacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidacyService
{
    @Autowired
    CandidacyRepository candidacyRepository;

    public List<Candidacy> getAllCandidacies()
    {
        List<Candidacy> candidacies = new ArrayList<>();
        candidacyRepository.findAll().forEach(candidacies::add);
        return candidacies;
    }

    public Optional<Candidacy> getCandidacy(Integer candidacyid){
        return candidacyRepository.findById(candidacyid);
    }

    public void addCandidacy(Candidacy candidacy) {
        candidacyRepository.save(candidacy);
    }

    // To be solved by students
    public void updateCandidacy(Integer candidacyid, Candidacy candidacy) {

    }

    public void deleteCandidacy(Integer candidacyid) {
        candidacyRepository.deleteById(candidacyid);
    }

    
}
