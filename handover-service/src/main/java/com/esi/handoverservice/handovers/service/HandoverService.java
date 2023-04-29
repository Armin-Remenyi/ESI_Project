package com.esi.handoverservice.handovers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.esi.handoverservice.handovers.dto.HandoverDto;

import com.esi.handoverservice.handovers.model.Handover;
import com.esi.handoverservice.handovers.repository.HandoverRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HandoverService {

    @Autowired
    HandoverRepository handoverRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Handover> getAllHandovers()
    {
        List<Handover> handovers = new ArrayList<>();
        handoverRepository.findAll().forEach(handovers::add);
        return handovers;
    }
    public Optional<Handover> getHandover(Integer handoverid){
        return handoverRepository.findById(handoverid);
    }

    public void addHandover(Handover handover) {
        handoverRepository.save(handover);
    }

    // To be solved by students
    public void updateHandover(Integer handoverid, Handover handover) {

    }

    public void deleteHandover(Integer handoverid) {
        handoverRepository.deleteById(handoverid);
    }
}
