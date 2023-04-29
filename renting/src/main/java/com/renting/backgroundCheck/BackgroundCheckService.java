package com.renting.backgroundCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackgroundCheckService {

    @Autowired
    BackgroundCheckRepository backgroundCheckRepository;

    public List<BackgroundCheck> getAllBackgroundChecks()
    {
        List<BackgroundCheck> backgroundChecks = new ArrayList<>();
        backgroundCheckRepository.findAll().forEach(backgroundChecks::add);
        return backgroundChecks;
    }

    public Optional<BackgroundCheck> getBackgroundCheck(Integer backgroundCheckid){
        return backgroundCheckRepository.findById(backgroundCheckid);
    }

    public void addBackgrounCheck(BackgroundCheck backgroundCheck) {
        backgroundCheckRepository.save(backgroundCheck);
    }

    // TODO: To be solved by students
    public void updateBackgrounCheck(Integer backgroundCheckid, BackgroundCheck backgroundCheck) {

    }

    // TODO: To be solved by students
    public void deleteBackgrounCheck(Integer backgroundCheckid) {
        backgroundCheckRepository.deleteById(backgroundCheckid);
    }

    
}
