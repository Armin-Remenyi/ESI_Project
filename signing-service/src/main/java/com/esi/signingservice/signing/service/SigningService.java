package com.esi.signingservice.signing.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esi.signingservice.signing.dto.SigningDto;
import com.esi.signingservice.signing.model.Signing;
import com.esi.signingservice.signing.repository.SigningRepository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SigningService {

    @Autowired
    SigningRepository signingRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;


    public List<SigningDto> getAllSignings(){
        List<Signing> signings =  new ArrayList<>();
        signingRepository.findAll().forEach(signings::add);
        return signings.stream().map(this::mapToSigningDto).toList();
        }
            private SigningDto mapToSigningDto(Signing signing){
                    return SigningDto.builder()
                            .signingId(signing.getSigningId())
                            .tenantSignDate(signing.getTenantSignDate())
                            .landlordSignDate(signing.getLandlordSignDate())
                            .document(signing.getDocument())
                            .tenantSign(signing.getTenantSign())
                            .landlordSign(signing.getLandlordSign())
                            .build();
                }
                public Optional<SigningDto> getSigning(Integer signingId){
                Optional<Signing> signing = signingRepository.findById(signingId);
                return signing.map(this::mapToSigningDto);
            }
    
            public void addSigning(SigningDto signingDto) {
                Signing signing = Signing.builder()
                .signingId(signingDto.getSigningId())
                .tenantSignDate(signingDto.getTenantSignDate())
                .landlordSignDate(signingDto.getLandlordSignDate())
                .document(signingDto.getDocument())
                .tenantSign(signingDto.getTenantSign())
                .landlordSign(signingDto.getLandlordSign())
                .build();
                signingRepository.save(signing);
            log.info("Signing {} is added to the Database", signing.getSigningId());
            }
    
            public void updateSigning(Integer signingId, SigningDto signingDto) {
                Signing signing = Signing.builder()
                .signingId(signingDto.getSigningId())
                .tenantSignDate(signingDto.getTenantSignDate())
                .landlordSignDate(signingDto.getLandlordSignDate())
                .document(signingDto.getDocument())
                .tenantSign(signingDto.getTenantSign())
                .landlordSign(signingDto.getLandlordSign())
                .build();
                signingRepository.save(signing);
            log.info("Signing {} is updated", signing.getSigningId());
            }
    
            public void deleteSigning(Integer signingId) {
            signingRepository.deleteById(signingId);
            log.info("A Signing has been deleted");
            }

}
