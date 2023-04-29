package com.esi.candidacyservice.candidacies.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.esi.candidacyservice.candidacies.dto.CandidacyDto;

import com.esi.candidacyservice.candidacies.model.candidacy;
import com.esi.candidacyservice.candidacies.repository.CandidacyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CandidacyService {

    @Autowired
    CandidacyRepository candidacyRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Candidacy> getAllCandidacys()
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
