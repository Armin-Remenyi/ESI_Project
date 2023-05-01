package com.esi.backgroundcheckservice.backgroundchecks.repository;

import org.springframework.data.repository.CrudRepository;
import com.esi.backgroundcheckservice.backgroundchecks.model.BackgroundCheck;

public interface BackgroundCheckRepository extends CrudRepository<BackgroundCheck, Integer>{
    
}
