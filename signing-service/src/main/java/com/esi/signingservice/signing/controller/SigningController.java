package com.esi.signingservice.signing.controller;
import com.esi.signingservice.signing.dto.SigningDto;
import com.esi.signingservice.signing.service.SigningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SigningController
{
    @Autowired
    private SigningService signingService;

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
