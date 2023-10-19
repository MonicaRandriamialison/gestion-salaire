package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.implementation;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.JobDTO;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.Employee;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.Job;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.repository.JobRepository;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.exception.RessourceNotFoundException;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.JobService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    private ModelMapper modelMapper;

    @Override
    public JobDTO createJob(JobDTO jobDTO) {
        Job job = modelMapper.map(jobDTO,Job.class);
        Job savedJob = jobRepository.save(job);
        return modelMapper.map(savedJob, JobDTO.class);
    }

    @Override
    public JobDTO getJobById(UUID jobId) {
        Optional<Job> optionalJob = jobRepository.findById(jobId);
        if (optionalJob.isPresent()){
            Job job = optionalJob.get();
            return modelMapper.map(job, JobDTO.class);
        } else throw new RessourceNotFoundException(jobId, Job.class.getName());
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map((job) -> modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
    }

    @Override
    public JobDTO updateJob(JobDTO jobDTO) {
        Job job = new Job();
        Optional<Job> optionalJob = jobRepository.findById(jobDTO.getId());
        if (optionalJob.isPresent()){
            job = optionalJob.get();
        }else throw new RessourceNotFoundException(jobDTO.getId(),Job.class.getName());
        job.setTitle(jobDTO.getTitle());
        job.setBaseSalary(jobDTO.getBaseSalary());
        job.setClassification(jobDTO.getClassification());

        Job updatedJob = jobRepository.save(job);
        return modelMapper.map(job,JobDTO.class);
    }

    @Override
    public void deleteJob(UUID jobId) {
    jobRepository.deleteById(jobId);
    }
}
