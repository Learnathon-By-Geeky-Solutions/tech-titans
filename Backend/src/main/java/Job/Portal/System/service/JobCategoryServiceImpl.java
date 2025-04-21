package Job.Portal.System.service;

import Job.Portal.System.model.JobCategory;
import Job.Portal.System.repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {


    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    /**
     * Method to add a new job category
     */

    @Override
    public JobCategory addJobCategory(JobCategory jobCategory) {
        return jobCategoryRepository.save(jobCategory);  // Save and return the new job category.
    }

    /**
     * Method to update an existing job category
     */

    @Override
    public JobCategory updateJobCategory(JobCategory jobCategory) {
        return jobCategoryRepository.save(jobCategory);  // Save and return the updated job category.
    }

    /**
     * Method to get all job categories
     */

    @Override
    public List<JobCategory> getAllJobCategories() {
        return jobCategoryRepository.findAll();
    }

    /**
     * Method to delete a job category by its ID
     */

    @Override
    public void deleteJobCategory(Long id) {
        jobCategoryRepository.deleteById(id);
    }


    /**
     * Method to find a job category by its ID
     * If the category is not found, it returns null.
     */

    @Override
    public JobCategory findById(Long id) {
        return jobCategoryRepository.findById(id).orElse(null);
    }
}
