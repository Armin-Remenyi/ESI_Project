package src.main.java.com.esi.signingservice.signing.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.com.esi.signingservice.signing.model.Signing;
import src.main.java.com.esi.signingservice.signing.repository.SigningRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SigningService {

    @Autowired
    SigningRepository signingRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Signing> getAllSignings()
    {
        List<Signing> signings = new ArrayList<>();
        signingRepository.findAll().forEach(signings::add);
        return signings;
    }

    public Optional<Signing> getSigning(Integer signingId){
        return signingRepository.findById(signingId);
    }

    public void addSigning(Signing signing) {
        signingRepository.save(signing);
    }

    // TODO: updateSigning
    public void updateSigning(Integer signingId, Signing signing) {


    }

    public void deleteSigning(Integer signingId) {
        signingRepository.deleteById(signingId);

    }

}
