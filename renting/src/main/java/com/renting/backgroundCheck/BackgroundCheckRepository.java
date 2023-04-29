package com.renting.backgroundCheck;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundCheckRepository extends CrudRepository<BackgroundCheck, Integer> {
    
}
