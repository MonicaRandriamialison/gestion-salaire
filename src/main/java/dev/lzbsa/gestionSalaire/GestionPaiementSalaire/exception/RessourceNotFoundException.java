package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.exception;

import java.util.UUID;

public class RessourceNotFoundException extends RuntimeException{
    public RessourceNotFoundException(UUID id, String className){
        super("Could Not find" + className + "with ID: " + id);
    }
}
