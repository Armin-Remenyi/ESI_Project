package com.esi.contractservice.contracts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.esi.contractservice.contracts.dto.ContractDto;

import com.esi.contractservice.contracts.model.Contract;
import com.esi.contractservice.contracts.repository.ContractRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContractService {

@Autowired
private ContractRepository contractRepository;

@Autowired
private WebClient.Builder webClientBuilder;

private final KafkaTemplate<String, ContractDto> kafkaTemplate;

    @KafkaListener(topics = "signatureTopic", groupId = "contractSignatureGroup" )
    public void updateSigninginfo(ContractDto contractDto){
        Contract contract = Contract.builder()
        .contractid(contractDto.getContractid())
        .tenantid(contractDto.getTenantid())
        .landlordid(contractDto.getLandlordid())
        .propertyid(contractDto.getPropertyid())
        .listingid(contractDto.getListingid())
        .handoverid(contractDto.getHandoverid())
        .pets(contractDto.getPets())
        .status(contractDto.getStatus())
        .signing(contractDto.getSigning())
        .price(contractDto.getPrice())
        .build();
    contractRepository.save(contract);
    log.info("Signing {} status updated", contract.getContractid());
    }

    
    public List<ContractDto> getAllContracts(){
    List<Contract> contracts =  new ArrayList<>();
    contractRepository.findAll().forEach(contracts::add);
    return contracts.stream().map(this::mapToContractDto).toList();
    }

    private ContractDto mapToContractDto(Contract contract) {
        return ContractDto.builder()
                .contractid(contract.getContractid())
                .tenantid(contract.getTenantid())
                .landlordid(contract.getLandlordid())
                .propertyid(contract.getPropertyid())
                .listingid(contract.getListingid())
                .handoverid(contract.getHandoverid())
                .pets(contract.getPets())
                .status(contract.getStatus())
                .signing(contract.getSigning())
                .price(contract.getPrice())
                .build();
    }

    public Optional<ContractDto> getContract(Integer contractid) {
        Optional<Contract> contract = contractRepository.findById(contractid);
        return contract.map(this::mapToContractDto);
    }

    public void addContract(ContractDto contractDto) {
        Contract contract = Contract.builder()
                .contractid(contractDto.getContractid())
                .tenantid(contractDto.getTenantid())
                .landlordid(contractDto.getLandlordid())
                .propertyid(contractDto.getPropertyid())
                .listingid(contractDto.getListingid())
                .handoverid(contractDto.getHandoverid())
                .pets(contractDto.getPets())
                .status(contractDto.getStatus())
                .signing(contractDto.getSigning())
                .price(contractDto.getPrice())
                .build();
        contractRepository.save(contract);
        kafkaTemplate.send("ContractCreationTopic", contractDto);
        log.info("Contract {} is added to the Database", contract.getContractid());
    }

    public void updateContract(Integer contractid, ContractDto contractDto) {
        Contract contract = Contract.builder()
                .contractid(contractDto.getContractid())
                .tenantid(contractDto.getTenantid())
                .landlordid(contractDto.getLandlordid())
                .propertyid(contractDto.getPropertyid())
                .listingid(contractDto.getListingid())
                .handoverid(contractDto.getHandoverid())
                .pets(contractDto.getPets())
                .status(contractDto.getStatus())
                .signing(contractDto.getSigning())
                .price(contractDto.getPrice())
                .build();
        contractRepository.save(contract);


        Optional<ContractDto> contractGet = contractRepository.findById(contractid).map(this::mapToContractDto);
        if (contractGet.isPresent() && !contractGet.get().getStatus().equals(contract.getStatus())) {
            kafkaTemplate.send("ContractStatusUpdateTopic", contractDto);
        }

        // Event when contract status only changed to SIGNED
        if (contractGet.isPresent() && !contractGet.get().getSigning().equals(contract.getSigning())) {
            kafkaTemplate.send("ContractSignUpdateTopic", contractDto);
        }

        log.info("Contract {} is updated", contract.getContractid());
    }

        public void deleteContract(Integer contractid) {
        // TODO: Delete contractId from listing.
        contractRepository.deleteById(contractid);
        log.info("A Contract has been deleted");
        }
};

