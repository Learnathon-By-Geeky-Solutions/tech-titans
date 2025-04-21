package Job.Portal.System.service;

import Job.Portal.System.model.JobApplication;
import Job.Portal.System.model.User;
import Job.Portal.System.model.Job;
import Job.Portal.System.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {


    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    /**
     * This method saves the job application to the repository and returns the saved application
     */
    @Override
    public JobApplication applyForJob(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);  // Save and return the job application.
    }

    /**
     * This Method to get job applications by job seeker (user)
     */
    @Override
    public List<JobApplication> getJobApplicationsByJobSeeker(User jobSeeker) {
        return jobApplicationRepository.findByJobSeeker(jobSeeker);  // Return list of job applications by job seeker.
    }

    /**
     * This method retrieves a list of job applications associated with a specific job
     */
    @Override
    public List<JobApplication> getJobApplicationsByJob(Job job) {
        return jobApplicationRepository.findByJob(job);  // Return list of job applications by job.
    }

    /**
     * This method retrieves a list of all job applications in the system
     */
    @Override
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();  // Return all job applications.
    }

    /**
     * This method finds a job application by its ID, updates its status, and saves the updated application
     */
    @Override
    public JobApplication updateJobApplicationStatus(Long id, JobApplication.Status status) {
        JobApplication jobApplication = jobApplicationRepository.findById(id).orElse(null);

        if (jobApplication != null) {  // If the job application exists,
            jobApplication.setStatus(status);  // Update the status.
            return jobApplicationRepository.save(jobApplication);  // Save and return the updated job application.
        }

        return null;  // Return null if the job application is not found.
    }
}
