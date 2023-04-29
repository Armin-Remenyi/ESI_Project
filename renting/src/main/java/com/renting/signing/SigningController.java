package com.renting.signing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SigningController
{
    private  List<Signing> signatures =  new ArrayList<>(Arrays.asList(
        new Signing(1, LocalDate.of(2023, 1, 13), LocalDate.of(2023, 1, 14), "PDF", "Ingmar", "Peeter"))
     );
 
     @GetMapping("/signatures")
     public List<Signing> getAllSigning()
     {
         return signatures;
     }
 
     @GetMapping("/signatures/{id}")
     public Signing getSigning(@PathVariable Integer signingid)
     {
         return signatures.stream().filter(c->c.getSigningid().equals(signingid)).findFirst().get();
     }
 
     @PostMapping("/signatures")
     public void addSigning(@RequestBody Signing signature)
     {
        signatures.add(signature);    
     }
 
     @PutMapping("/signatures/{id}")
     public void updateSigning(@RequestBody Signing signature, @PathVariable Integer signingid)
     {
         for (int i = 0; i < signatures.size(); i++)
         {
            Signing c = signatures.get(i);
             if (c.getSigningid().equals(signingid)){
                signatures.set(i, signature);
             return;}
         }
     }
 
     @DeleteMapping("/signatures/{id}")
     public void deleteSigning(@PathVariable Integer signingid)
     {
        signatures.removeIf(c->c.getSigningid().equals(signingid));
     }
}
