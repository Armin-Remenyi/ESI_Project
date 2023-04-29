package src.main.java.com.esi.signingservice.signing.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SigningDto {

    @Id
    private Integer signingId;
    private LocalDate tenantSignDate;
    private LocalDate landlordSignDate;
    private String document;
    private String tenantSign;
    private String landlordSign;

    public SigningDto(Integer signingId)
    {
        this.signingId = signingId;
    }
}
