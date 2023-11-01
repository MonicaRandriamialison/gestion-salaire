package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.ServiceDTO;

import java.util.List;
import java.util.UUID;

public interface ServiceService {
    public ServiceDTO createService(ServiceDTO service);

    public ServiceDTO getServiceById(UUID serviceId);

    public List<ServiceDTO> getAllServices();

    public ServiceDTO updateEmployee(ServiceDTO service);

    public void deleteService(UUID serviceId);
}
