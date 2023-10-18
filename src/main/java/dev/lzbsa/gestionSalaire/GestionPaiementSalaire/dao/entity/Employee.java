package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstname;

    private String lastname;

    private String sexe;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    private Long registrationNumber;

    private String cin;

    private String email;

    private String phone;

    private String address;

    private Long numberOfChildren;

    private Long numberOfCnaps;

    @ManyToOne
    private Job job;


}

