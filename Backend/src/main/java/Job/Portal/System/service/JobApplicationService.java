package Job.Portal.System.service;

import Job.Portal.System.model.JobApplication;
import Job.Portal.System.model.User;
import Job.Portal.System.model.Job;

import java.util.List;

public interface JobApplicationService {
    // Method to apply for a job
    JobApplication applyForJob(JobApplication jobApplication);

    // Method to get job applications by job seeker (user)
    List<JobApplication> getJobApplicationsByJobSeeker(User jobSeeker);

    // Method to get job applications by job
    List<JobApplication> getJobApplicationsByJob(Job job);

    // Method to get all job applications
    List<JobApplication> getAllJobApplications();

    // Method to update the status of a job application by its ID
    JobApplication updateJobApplicationStatus(Long id, JobApplication.Status status);
}
