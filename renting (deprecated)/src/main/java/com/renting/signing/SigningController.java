package com.renting.signing;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class SigningController {
    private List<Signing> signatures = new ArrayList<>(Arrays.asList(
            new Signing(1, LocalDate.of(2023, 1, 13), LocalDate.of(2023, 1, 14), "PDF", "Ingmar", "Peeter"))
    );

    @GetMapping("/signing")
    public List<Signing> getAllSigning() {
        return signatures;
    }

    @GetMapping("/signing/{id}")
    public Signing getSigning(@PathVariable Integer signingId) {
        return signatures.stream().filter(c -> c.getSigningId().equals(signingId)).findFirst().get();
    }

    @PostMapping("/signing")
    public void addSigning(@RequestBody Signing signature) {
        signatures.add(signature);
    }

    @PutMapping("/signing/{id}")
    public void updateSigning(@RequestBody Signing signature, @PathVariable Integer signingId) {
        for (int i = 0; i < signatures.size(); i++) {
            Signing c = signatures.get(i);
            if (c.getSigningId().equals(signingId)) {
                signatures.set(i, signature);
                return;
            }
        }
    }

    @DeleteMapping("/signing/{id}")
    public void deleteSigning(@PathVariable Integer signingId) {
        signatures.removeIf(c -> c.getSigningId().equals(signingId));
    }
}
