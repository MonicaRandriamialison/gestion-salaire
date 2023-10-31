package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.implementation;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.EmployeeDTO;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.Employee;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.Job;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.repository.EmployeeRepository;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.repository.JobRepository;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.exception.RessourceNotFoundException;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private JobRepository jobRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO.getFirstname());
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO getEmployeeById(UUID employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            return modelMapper.map(employee, EmployeeDTO.class);
        } else throw new RessourceNotFoundException(employeeId, Employee.class.getName());
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> modelMapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDTO.getId());
        if (optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
        } else throw new RessourceNotFoundException(employeeDTO.getId(),Employee.class.getName());
        employee.setFirstname(employeeDTO.getFirstname());
        employee.setLastname(employeeDTO.getLastname());
        employee.setSexe(employeeDTO.getSexe());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setRegistrationNumber(employeeDTO.getRegistrationNumber());
        employee.setCin(employeeDTO.getCin());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());
        employee.setAddress(employeeDTO.getAddress());
        employee.setNumberOfChildren(employeeDTO.getNumberOfChildren());
        employee.setNumberOfCnaps(employeeDTO.getNumberOfCnaps());

        Employee updatedEmployee = employeeRepository.save(employee);
        return modelMapper.map(updatedEmployee,EmployeeDTO.class);


    }

    @Override
    public void deleteEmployee(UUID employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public EmployeeDTO assignEmployeeToJob(UUID employeeId, UUID jobId) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Optional<Job> optionalJob = jobRepository.findById(jobId);

        if (optionalJob.isPresent()){
           Job job = optionalJob.get();
            if (optionalEmployee.isPresent()){
               Employee employee = optionalEmployee.get();
               employee.setJob(job);
               job.getEmployees().add(employee);
               jobRepository.save(job);
               employeeRepository.save(employee);
               return modelMapper.map(employee, EmployeeDTO.class);
            }else throw new RessourceNotFoundException(employeeId ,Employee.class.getName());
        }else throw new RessourceNotFoundException(jobId,Job.class.getName());

    }


}
