package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.repository;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MissionRepository extends JpaRepository<Mission, UUID> {
}
