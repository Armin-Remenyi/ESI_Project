package com.renting.candidacy;

import java.util.ArrayList;
import java.util.List;

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
    
}
