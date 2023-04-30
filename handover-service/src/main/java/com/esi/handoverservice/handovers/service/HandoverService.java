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

    public List<HandoverDto> getAllHandovers()
    {
        List<Handover> handovers = new ArrayList<>();
        handoverRepository.findAll().forEach(handovers::add);
        return handovers.stream().map(this::mapToHandoverDto).toList();
    }

        private HandoverDto mapToHandoverDto(Handover handover){
                return HandoverDto.builder()
                        .handoverid(handover.getHandoverid())
                        .date(handover.getDate())
                        .keys(handover.getKeys())
                        .coldwater(handover.getColdwater())
                        .hotwater(handover.getHotwater())
                        .status(handover.getStatus())
                        .signatures(handover.getSignatures())
                        .build();
            }
            public Optional<HandoverDto> getHandover(Integer handoverid){
            Optional<Handover> handover = handoverRepository.findById(handoverid);
            return handover.map(this::mapToHandoverDto);
        }

        public void addHandover(HandoverDto handoverDto) {
            Handover handover = Handover.builder()
            .handoverid(handoverDto.getHandoverid())
            .date(handoverDto.getDate())
            .keys(handoverDto.getKeys())
            .coldwater(handoverDto.getColdwater())
            .hotwater(handoverDto.getHotwater())
            .status(handoverDto.getStatus())
            .signatures(handoverDto.getSignatures())
            .build();
        handoverRepository.save(handover);
        log.info("Contract {} is added to the Database", handover.getHandoverid());
        }

        public void updateHandover(Integer handoverid, HandoverDto handoverDto) {
        Handover handover = Handover.builder()
            .handoverid(handoverDto.getHandoverid())
            .date(handoverDto.getDate())
            .keys(handoverDto.getKeys())
            .coldwater(handoverDto.getColdwater())
            .hotwater(handoverDto.getHotwater())
            .status(handoverDto.getStatus())
            .signatures(handoverDto.getSignatures())
            .build();
        handoverRepository.save(handover);
        log.info("Contract {} is updated", handover.getHandoverid());
        }

    public void deleteHandover(Integer handoverid) {
        handoverRepository.deleteById(handoverid);
        log.info("A Contract has been deleted");
    }
};
