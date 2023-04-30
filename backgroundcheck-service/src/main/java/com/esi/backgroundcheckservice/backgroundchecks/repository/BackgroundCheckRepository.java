package com.esi.backgroundcheckservice.backgroundchecks.repository;

import org.springframework.data.repository.CrudRepository;
import com.esi.candidacyservice.candidacies.model.Candidacy;

public interface BackgroundCheckRepository extends CrudRepository<Candidacy, Integer>{
    
}
