package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.implementation;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.ServiceDTO;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.repository.ServiceRepository;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.ServiceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ServiceImpl implements ServiceService {

    private ServiceRepository serviceRepository;
    private ModelMapper modelMapper;
    @Override
    public ServiceDTO createService(ServiceDTO service) {
        return null;
    }

    @Override
    public ServiceDTO getServiceById(UUID serviceId) {
        return null;
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        return null;
    }

    @Override
    public ServiceDTO updateEmployee(ServiceDTO service) {
        return null;
    }

    @Override
    public void deleteService(UUID serviceId) {

    }
}
