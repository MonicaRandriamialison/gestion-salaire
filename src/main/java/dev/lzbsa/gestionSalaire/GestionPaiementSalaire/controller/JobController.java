package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.controller;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.JobDTO;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/job")
@AllArgsConstructor
public class JobController {
    private JobService jobService;

    @GetMapping
    @RequestMapping
    public List<JobDTO> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public JobDTO getJobById(@PathVariable("id")UUID jobId){
        JobDTO jobDTO = jobService.getJobById(jobId);
        return jobService.getJobById(jobId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobDTO createJob (@RequestBody JobDTO jobDTO){
        return jobService.createJob(jobDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public JobDTO updateJob (@PathVariable("id")UUID jobId, @RequestBody JobDTO jobDTO){
        jobDTO.setId(jobId);
        JobDTO updateJob = jobService.updateJob(jobDTO);
        return jobService.updateJob(jobDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") UUID jobId){
        jobService.deleteJob(jobId);
        return new ResponseEntity<>("Job successfully deleted!",HttpStatus.OK);
    }
}
