package com.renting.candidacy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidacyRepository extends CrudRepository<Candidacy, Integer>{
    
}
