package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.controller;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.EmployeeDTO;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.Employee;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> getAllEmployees(){

        return employeeService.getAllEmployees();
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id")UUID employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO createEmployee (@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createEmployee(employeeDTO);
    }

    @PostMapping("assign/{employeeId}/job/{jobId}")
    public EmployeeDTO assignEmployeeToJob (@PathVariable("employeeId") UUID employeeId, @PathVariable("jobId") UUID jobId){
        return employeeService.assignEmployeeToJob(employeeId,jobId);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO updateEmployee(@PathVariable("id")UUID employeeId, @RequestBody EmployeeDTO employeeDTO){
        employeeDTO.setId(employeeId);
        EmployeeDTO updateEmployee = employeeService.updateEmployee(employeeDTO);
        return employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") UUID employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("User successfully deleted!",HttpStatus.OK);
    }



}
