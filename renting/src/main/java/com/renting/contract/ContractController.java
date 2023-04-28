package com.renting.contract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController
{
    private  List<Contract> contracts =  new ArrayList<>(Arrays.asList(
        new Contract(12, 12, 32, 4, 5, "No", "Complete", "Signed"),
        new Contract(144, 1, 2, 6, 9, "Yes", "Waiting", "Waiting")
     ));
 
     @GetMapping("/contracts")
     public List<Contract> getAllContract()
     {
         return contracts;
     }
 
     @GetMapping("/contracts/{id}")
     public Contract getContract(@PathVariable Integer contractid)
     {
         return contracts.stream().filter(c->c.getContractid().equals(contractid)).findFirst().get();
     }
 
     @PostMapping("/contracts")
     public void addContract(@RequestBody Contract contract)
     {
        contracts.add(contract);    
     }
 
     @PutMapping("/contracts/{id}")
     public void updateContract(@RequestBody Contract contract, @PathVariable Integer contractid)
     {
         for (int i = 0; i < contracts.size(); i++)
         {
            Contract c = contracts.get(i);
             if (c.getContractid().equals(contractid)){
                contracts.set(i, contract);
             return;}
         }
     }
 
     @DeleteMapping("/contracts/{id}")
     public void deleteContract(@PathVariable Integer contractid)
     {
        contracts.removeIf(c->c.getContractid().equals(contractid));
     }      
}
