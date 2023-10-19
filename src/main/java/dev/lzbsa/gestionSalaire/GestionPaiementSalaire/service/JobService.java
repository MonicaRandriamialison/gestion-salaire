package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.JobDTO;

import java.util.List;
import java.util.UUID;

public interface JobService {
    public JobDTO createJob(JobDTO job);

    public JobDTO getJobById(UUID jobId);

    public List<JobDTO> getAllJobs();

    public JobDTO updateJob(JobDTO job);

    public void deleteJob(UUID jobId);
}
