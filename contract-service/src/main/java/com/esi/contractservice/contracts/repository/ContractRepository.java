package com.esi.contractservice.contracts.repository;

import org.springframework.data.repository.CrudRepository;

import com.esi.contractservice.contracts.model.Contract;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, Integer>{
    List<Contract> findByListingid(Integer listingid);
}
