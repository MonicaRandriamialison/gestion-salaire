package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor
public class EmployeeDTO {
    private UUID id;

    private String firstname;

    private String lastname;

    private String sexe;

    private LocalDate dateOfBirth;

    private Long registrationNumber;

    private String cin;

    private String email;

    private String phone;

    private String address;

    private Long numberOfChildren;

    private Long numberOfCnaps;
}
