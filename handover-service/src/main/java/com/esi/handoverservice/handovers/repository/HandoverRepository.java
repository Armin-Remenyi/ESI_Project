package com.esi.handoverservice.handovers.repository;

import org.springframework.data.repository.CrudRepository;
import com.esi.handoverservice.handovers.model.Handover;

public interface HandoverRepository extends CrudRepository<Handover, Integer>{
    
}
