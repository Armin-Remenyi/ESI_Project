package com.esi.contractservice.contracts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.esi.contractservice.contracts.dto.ContractDto;

import com.esi.contractservice.contracts.model.Contract;
import com.esi.contractservice.contracts.repository.ContractRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContractService {

@Autowired
private ContractRepository contractRepository;

@Autowired
private WebClient.Builder webClientBuilder;

    public List<ContractDto> getAllContracts(){
    List<Contract> contracts =  new ArrayList<>();
    contractRepository.findAll().forEach(contracts::add);
    return contracts.stream().map(this::mapToContractDto).toList();
    }
        private ContractDto mapToContractDto(Contract contract){
                return ContractDto.builder()
                        .contractid(contract.getContractid())
                        .tenantid(contract.getTenantid())
                        .landlordid(contract.getLandlordid())
                        .propertyid(contract.getPropertyid())
                        .handoverid(contract.getHandoverid())
                        .pets(contract.getPets())
                        .status(contract.getStatus())
                        .signing(contract.getSigning())
                        .build();
            }
            public Optional<ContractDto> getContract(Integer contractid){
            Optional<Contract> contract = contractRepository.findById(contractid);
            return contract.map(this::mapToContractDto);
        }

        public void addContract(ContractDto contractDto) {
            Contract contract = Contract.builder()
            .contractid(contractDto.getContractid())
            .tenantid(contractDto.getTenantid())
            .landlordid(contractDto.getLandlordid())
            .propertyid(contractDto.getPropertyid())
            .handoverid(contractDto.getHandoverid())
            .pets(contractDto.getPets())
            .status(contractDto.getStatus())
            .signing(contractDto.getSigning())
            .build();
        contractRepository.save(contract);
        log.info("Contract {} is added to the Database", contract.getContractid());
        }

        public void updateContract(Integer contractid, ContractDto contractDto) {
        Contract contract = Contract.builder()
            .contractid(contractDto.getContractid())
            .tenantid(contractDto.getTenantid())
            .landlordid(contractDto.getLandlordid())
            .propertyid(contractDto.getPropertyid())
            .handoverid(contractDto.getHandoverid())
            .pets(contractDto.getPets())
            .status(contractDto.getStatus())
            .signing(contractDto.getSigning())
            .build();
        contractRepository.save(contract);
        log.info("Contract {} is updated", contract.getContractid());
        }

        public void deleteContract(Integer contractid) {
        contractRepository.deleteById(contractid);
        log.info("A Contract has been deleted");
        }
};

