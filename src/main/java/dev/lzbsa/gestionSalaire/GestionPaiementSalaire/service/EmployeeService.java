package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.EmployeeDTO;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    public EmployeeDTO createEmployee(EmployeeDTO employee);

    public EmployeeDTO getEmployeeById(UUID employeeId);

    public List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO updateEmployee(EmployeeDTO employee);

    public void deleteEmployee(UUID employeeId);

    public EmployeeDTO assignEmployeeToJob (UUID employeeId , UUID jobId);
}
