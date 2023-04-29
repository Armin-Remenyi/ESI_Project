package com.esi.contractservice.contracts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.esi.contractservice.contracts.dto.ContractDto;

/* 
import com.esi.productservice.products.dto.ProductDto;
import com.esi.productservice.products.dto.ProductQuantityDto;
*/

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

    public   List<ContractDto> getAllContracts(){
    List<Contract> contracts =  new ArrayList<>();
    contractRepository.findAll().forEach(contracts::add);
    return contracts.stream().map(this::mapToContractDto).toList();
    }    

    /* 
        private ContractDto mapToContractDto(Contract contract) {
                return ContractDto.builder()
                        .id(contract.getId())
                        .name(contract.getName())
                        .description(contract.getDescription())
                        .price(contract.getPrice())
                        .code(contract.getCode())
                        .build();
            }

*/
            public   Optional<ContractDto>  getContract(String id){
            Optional<Contract> contract =  contractRepository.findById(contractid);
            return contract.map(this::mapToContractDto);
        }
        

// TBD
        public void addContract(ContractDto contractDto) {
            Contract contract = Contract.builder()
            .contractid(contractDto.getContractId())
            .tenantid(contractDto.getTenantId())
            .landlordid(contractDto.getLandlord())
            .propertyid(contractDto.getDescription())
            .build();
        contractRepository.save(contract);
        log.info("contract {} is added to the Database", contract.getContractId());
        }

        public void updateContract(String contractid, ContractDto contractdto) {
            Contract product = Contract.builder()
            contractid(contractDto.getContractId())
            .tenantid(contractDto.getTenantId())
            .landlordid(contractDto.getLandlord())
            .propertyid(contractDto.getDescription())
            .build();
        contractRepository.save(contract);
        log.info("contract {} is updated", contract.getId());
        }

        public void deleteContract(String contractid) {
        contractRepository.deleteById(contractid);
        log.info("A Contract has been deleted");
        }
    };

