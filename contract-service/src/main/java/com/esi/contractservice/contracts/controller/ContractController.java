package com.esi.contractservice.contracts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esi.contractservice.contracts.dto.ContractDto;
import com.esi.contractservice.contracts.service.ContractService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ContractController
{
    @Autowired
    private ContractService contractService;
 
     @GetMapping("/contracts")
     public List<ContractDto> getAllContracts()
     {
         return contractService.getAllContracts();
     }
 
     @GetMapping("/contracts/{contractid}")
     public Optional <ContractDto> getContract(@PathVariable Integer contractid)
     {
         return contractService.getContract(contractid);
     }

    @GetMapping("/contracts/listing/{listingid}")
    public List<ContractDto> getAllContractsByListingId(@PathVariable Integer listingid) {
        return contractService.getAllContractsByListingId(listingid);
    }
 
     @PostMapping("/contracts")
     public void addContract(@RequestBody ContractDto contractDto)
     {
        contractService.addContract(contractDto);  
     }
 
     @PutMapping("/contracts/{contractid}")
     public void updateContract(@RequestBody ContractDto contractDto, @PathVariable Integer contractid)
     {
        contractService.updateContract(contractid, contractDto);
     }
 
     @DeleteMapping("/contracts/{contractid}")
     public void deleteContract(@PathVariable Integer contractid)
     {
        contractService.deleteContract(contractid);
     }      
}
