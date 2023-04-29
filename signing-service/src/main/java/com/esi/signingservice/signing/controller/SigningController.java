package com.esi.signingservice.signing.controller;

import org.springframework.web.bind.annotation.*;
import com.esi.signingservice.signing.model.Signing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SigningController {


    private List<Signing> signings = new ArrayList<>(Arrays.asList(
            new Signing(1, LocalDate.of(2023, 1, 14), LocalDate.of(2023, 1, 14), "www.pdf.ee", "signatureTenant", "signatureLandlord")
    ));

    @GetMapping("/signing")
    public List<Signing> getAllSignings() {
        return signings;
    }

    @GetMapping("/signing/{id}")
    public Signing getSigning(@PathVariable Integer signingId) {
        return signings.stream().filter(c -> c.getSigningId().equals(signingId)).findFirst().get();
    }

    @PostMapping("/signing")
    public void addSigning(@RequestBody Signing signing) {
        signings.add(signing);
    }

    @PutMapping("/signing/{id}")
    public void updateSigning(@RequestBody Signing signing, @PathVariable Integer signingId) {
        for (int i = 0; i < signings.size(); i++) {
            Signing c = signings.get(i);
            if (c.getSigningId().equals(signingId)) {
                signings.set(i, signing);
                return;
            }
        }
    }

    @DeleteMapping("/signing/{id}")
    public void deleteSigning(@PathVariable Integer signingId) {
        signings.removeIf(c -> c.getSigningId().equals(signingId));
    }

}
