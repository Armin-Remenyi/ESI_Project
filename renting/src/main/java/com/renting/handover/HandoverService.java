package com.renting.handover;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandoverService {

    @Autowired
    HandoverRepository handoverRepository;

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
