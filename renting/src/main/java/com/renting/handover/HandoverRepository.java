package com.renting.handover;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandoverRepository extends CrudRepository<Handover, Integer>{
    
}
