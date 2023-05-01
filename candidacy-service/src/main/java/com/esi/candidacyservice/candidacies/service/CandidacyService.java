package com.esi.candidacyservice.candidacies.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;


import com.esi.candidacyservice.candidacies.dto.CandidacyDto;

import com.esi.candidacyservice.candidacies.model.Candidacy;
import com.esi.candidacyservice.candidacies.repository.CandidacyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CandidacyService {

@Autowired
private CandidacyRepository candidacyRepository;

private final KafkaTemplate<String, CandidacyDto> kafkaTemplate;

@Autowired
private WebClient.Builder webClientBuilder;

    //Code taken from OderService.java, we need something similar
    @KafkaListener(topics = "backgrouchCheckTopic", groupId = "backgrouchCheckGroup" )
    public void updateBackgroudCheckinfo(CandidacyDto candidacyDto){
        Candidacy candidacy = Candidacy.builder()
        .candidacyid(candidacyDto.getCandidacyid())
        .userid(candidacyDto.getUserid())
        .property(candidacyDto.getProperty())
        .date(candidacyDto.getDate())
        .status(candidacyDto.getStatus())
        .build();
        candidacyRepository.save(candidacy);
    log.info("Candidacy {} payment status updated", candidacy.getCandidacyid());
    }


    public List<CandidacyDto> getAllCandidacies(){
    List<Candidacy> candidacies = new ArrayList<>();
    candidacyRepository.findAll().forEach(candidacies::add);
    return candidacies.stream().map(this::mapToCandidacyDto).toList();
    }
        private CandidacyDto mapToCandidacyDto(Candidacy candidacy) {
                return CandidacyDto.builder()
                        .candidacyid(candidacy.getCandidacyid())
                        .userid(candidacy.getUserid())
                        .property(candidacy.getProperty())
                        .date(candidacy.getDate())
                        .status(candidacy.getStatus())
                        .build();
            }
            public Optional<CandidacyDto> getCandidacy(Integer candidacyid){
            Optional<Candidacy> candidacy = candidacyRepository.findById(candidacyid);
            return candidacy.map(this::mapToCandidacyDto);
        }

        public void addCandidacy(CandidacyDto candidacyDto) {
            Candidacy candidacy = Candidacy.builder()
            .candidacyid(candidacyDto.getCandidacyid())
            .userid(candidacyDto.getUserid())
            .property(candidacyDto.getProperty())
            .date(candidacyDto.getDate())
            .status(candidacyDto.getStatus())
            .build();
        candidacyRepository.save(candidacy);
        log.info("Candidacy {} is added to the Database", candidacy.getCandidacyid());
        }

        public void updateCandidacy(Integer candidacyid, CandidacyDto candidacyDto) {
        Candidacy candidacy = Candidacy.builder()
            .candidacyid(candidacyDto.getCandidacyid())
            .userid(candidacyDto.getUserid())
            .property(candidacyDto.getProperty())
            .date(candidacyDto.getDate())
            .status(candidacyDto.getStatus())
            .build();
        candidacyRepository.save(candidacy);
        log.info("Candidacy {} is updated", candidacy.getCandidacyid());
        }
    
        public void deleteContract(Integer candidacyid) {
        candidacyRepository.deleteById(candidacyid);
        log.info("A Candidcy has been deleted");
        }
};
