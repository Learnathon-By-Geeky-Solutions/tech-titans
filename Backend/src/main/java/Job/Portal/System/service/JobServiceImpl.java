package Job.Portal.System.service;

import Job.Portal.System.model.Job;
import Job.Portal.System.model.Employee;
import Job.Portal.System.model.JobCategory;
import Job.Portal.System.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {


    @Autowired
    private JobRepository jobRepository;

    /**
     * Method to add a new job
     */
    @Override
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    /**
     * Method to retrieve jobs by the company (Employee)
     */
    @Override
    public List<Job> getJobsByCompany(Employee company) {
        return jobRepository.findByCompany(company);  // Return a list of jobs for the given company.
    }

    /**
     * Method to retrieve all jobs
     */
    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    /**
     * Method to search jobs based on a keyword in the title or description
     * This method filters jobs that contain the keyword in their title or description,
     * ignoring case differences, and returns the matching jobs as a list.
     */
    @Override
    public List<Job> searchJobs(String keyword) {
        return jobRepository.findAll().stream()
                .filter(job -> job.getTitle().toLowerCase().contains(keyword.toLowerCase())  // Match title with keyword.
                        || job.getDescription().toLowerCase().contains(keyword.toLowerCase()))  // Match description with keyword.
                .collect(Collectors.toList());  // Collect and return the list of matching jobs.
    }

    /**
     * Method to retrieve jobs by their category
     */
    @Override
    public List<Job> getJobsByCategory(JobCategory category) {
        return jobRepository.findByCategory(category);
    }

    /**
     * Method to find a job by its ID
     */
    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }
}
