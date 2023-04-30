package com.esi.signingservice.signing.controller;
import com.esi.signingservice.signing.dto.SigningDto;
import com.esi.signingservice.signing.model.Signing;
import com.esi.signingservice.signing.service.SigningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SigningController
{
    @Autowired
    private SigningService signingService;

    // private List<Signing> signings = new ArrayList<>(Arrays.asList(
    //         new Signing(1, LocalDate.of(2023, 1, 14), LocalDate.of(2023, 1, 14), "www.pdf.ee", "signatureTenant", "signatureLandlord")
    // ));

    @GetMapping("/signings")
    public List<SigningDto> getAllSignings() {
        return signingService.getAllSignings();
    }

    @GetMapping("/signings/{id}")
    public Optional <SigningDto> getSigning(@PathVariable Integer signingId) {
        return signingService.getSigning(signingId);
    }

    @PostMapping("/signings")
    public void addSigning(@RequestBody SigningDto signingDto) {
        signingService.addSigning(signingDto);
    }

    @PutMapping("/signings/{id}")
    public void updateSigning(@RequestBody SigningDto signingDto, @PathVariable Integer signingId) {
        signingService.updateSigning(signingId, signingDto);
    }

    @DeleteMapping("/signings/{id}")
    public void deleteSigning(@PathVariable Integer signingId) {
        signingService.deleteSigning(signingId);
    }

}
