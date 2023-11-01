package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private UUID id;

    private String name;

    private String description;

}
