package com.esi.signingservice.signing.repository;

import org.springframework.data.repository.CrudRepository;
import com.esi.signingservice.signing.model.Signing;

public interface SigningRepository extends CrudRepository<Signing, Integer>{

}
