package Job.Portal.System.service;

import Job.Portal.System.model.JobCategory;
import java.util.List;

public interface JobCategoryService {

    // Method to add a new job category
    JobCategory addJobCategory(JobCategory jobCategory);

    // Method to update an existing job category
    JobCategory updateJobCategory(JobCategory jobCategory);

    // Method to get all job categories
    List<JobCategory> getAllJobCategories();

    // Method to delete a job category by its ID
    void deleteJobCategory(Long id);

    // Method to find a job category by its ID
    JobCategory findById(Long id);
}
