package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany
    private List<Employee> employees;
    
    private String title;

    private Double baseSalary;

    private String classification;

    @OneToMany(mappedBy = "job")
    private List<Mission> missions;

    @OneToMany(mappedBy = "job")
    private List<Service> service;
}
