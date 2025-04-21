package Job.Portal.System.repository;

import Job.Portal.System.model.Job;
import Job.Portal.System.model.JobApplication;
import Job.Portal.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {


    /**
     * Find all job applications by the job seeker.
     */
    List<JobApplication> findByJobSeeker(User jobSeeker);

    /**
     * Find all job applications for a specific job.
     */
    List<JobApplication> findByJob(Job job);
}
