package com.esi.candidacyservice.candidacies.repository;

import org.springframework.data.repository.CrudRepository;
import com.esi.candidacyservice.candidacies.model.Candidacy;

public interface CandidacyRepository extends CrudRepository<Candidacy, Integer>{
    
}
