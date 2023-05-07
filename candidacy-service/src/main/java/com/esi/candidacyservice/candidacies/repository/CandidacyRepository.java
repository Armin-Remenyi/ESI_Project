package com.esi.candidacyservice.candidacies.repository;

import org.springframework.data.repository.CrudRepository;
import com.esi.candidacyservice.candidacies.model.Candidacy;

import java.util.List;

public interface CandidacyRepository extends CrudRepository<Candidacy, Integer>{
    List<Candidacy> findByListingid(Integer listingid);
}
