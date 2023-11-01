package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.repository;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {
}
