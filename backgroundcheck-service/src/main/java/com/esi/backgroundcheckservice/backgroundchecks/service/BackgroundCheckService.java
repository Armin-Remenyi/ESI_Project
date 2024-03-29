package com.esi.backgroundcheckservice.backgroundchecks.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import com.esi.backgroundcheckservice.backgroundchecks.dto.BackgroundCheckDto;
import com.esi.backgroundcheckservice.backgroundchecks.dto.CandidacyDto;
import com.esi.backgroundcheckservice.backgroundchecks.model.BackgroundCheck;
import com.esi.backgroundcheckservice.backgroundchecks.repository.BackgroundCheckRepository;


import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@Service
@Slf4j
@RequiredArgsConstructor
public class BackgroundCheckService {

    @Autowired
    BackgroundCheckRepository backgroundCheckRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final KafkaTemplate<String, BackgroundCheckDto> kafkaTemplate;


    public void backgroundCheckComplete(BackgroundCheckDto backgroundCheckDto){
        
        log.info("Log message - received from Background Check topic: {} ", backgroundCheckDto.toString());

    }

    public List<BackgroundCheckDto> getAllBackgroundChecks()
    {
        List<BackgroundCheck> backgroundChecks = new ArrayList<>();
        backgroundCheckRepository.findAll().forEach(backgroundChecks::add);
        return backgroundChecks.stream().map(this::mapToBackgroundCheckDto).toList();
    }

    private BackgroundCheckDto mapToBackgroundCheckDto(BackgroundCheck backgroundCheck) {
        return BackgroundCheckDto.builder()
                .backgroundCheckid(backgroundCheck.getBackgroundCheckid())
                .date(backgroundCheck.getDate())
                .build();
    }
    public Optional<BackgroundCheckDto> getBackgroundCheck(Integer backgroundCheckid){
    Optional<BackgroundCheck> backgroundCheck = backgroundCheckRepository.findById(backgroundCheckid);
    return backgroundCheck.map(this::mapToBackgroundCheckDto);
    }

    public void addBackgroundCheck(BackgroundCheckDto backgroundCheckDto) {
        BackgroundCheck backgroundCheck = BackgroundCheck.builder()
        .backgroundCheckid(backgroundCheckDto.getBackgroundCheckid())
        .date(backgroundCheckDto.getDate())
        .build();
        backgroundCheckRepository.save(backgroundCheck);
        kafkaTemplate.send("BackgroundCheckCompleted", backgroundCheckDto);
        log.info("Background Check {} is added to the Database", backgroundCheck.getBackgroundCheckid());
    }

    public void updateBackgroundCheck(Integer backgroundCheckid, BackgroundCheckDto backgroundCheckDto) {
            BackgroundCheck backgroundCheck = BackgroundCheck.builder()
            .backgroundCheckid(backgroundCheckDto.getBackgroundCheckid())
            .date(backgroundCheckDto.getDate())
            .build();
            backgroundCheckRepository.save(backgroundCheck);
            log.info("Background Check {} is updated", backgroundCheck.getBackgroundCheckid());
            }
  
    public void deleteBackgroundCheck(Integer backgroundCheckid) {
         backgroundCheckRepository.deleteById(backgroundCheckid);
        log.info("A Background Check has been deleted");
    }
};
