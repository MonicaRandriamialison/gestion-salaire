package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.controller;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.EmployeeDTO;
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

}
