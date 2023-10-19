package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.repository;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<Job, UUID> {
}
