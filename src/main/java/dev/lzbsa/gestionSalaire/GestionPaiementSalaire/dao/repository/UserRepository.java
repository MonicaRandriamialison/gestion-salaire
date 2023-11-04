package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.repository;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
