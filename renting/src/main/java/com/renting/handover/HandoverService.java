package com.renting.handover;

import java.util.ArrayList;
import java.util.List;

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
    
}
