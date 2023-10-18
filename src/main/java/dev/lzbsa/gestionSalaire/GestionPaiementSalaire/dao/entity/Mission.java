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

public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;


    private String description;

    @ManyToMany(mappedBy = "mission")
    private List<Job> jobs;

    @ManyToMany
    private Compensation compensation;
}
