package com.esi.handoverservice.handovers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.esi.handoverservice.handovers.dto.CandidacyDto;

import com.esi.handoverservice.handovers.model.Candidacy;
import com.esi.handoverservice.handovers.repository.HandoverRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CandidacyService {

    @Autowired
    HandoverRepository handoverRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Candidacy> getAllHandovers()
    {
        List<Candidacy> handovers = new ArrayList<>();
        handoverRepository.findAll().forEach(handovers::add);
        return handovers;
    }
    public Optional<Candidacy> getHandover(Integer handoverid){
        return handoverRepository.findById(handoverid);
    }

    public void addHandover(Candidacy handover) {
        handoverRepository.save(handover);
    }

    // To be solved by students
    public void updateHandover(Integer handoverid, Candidacy handover) {

    }

    public void deleteHandover(Integer handoverid) {
        handoverRepository.deleteById(handoverid);
    }
}
