package Job.Portal.System.controller;

import Job.Portal.System.model.JobCategory;
import Job.Portal.System.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-categories")
public class JobCategoryController {


    @Autowired
    private JobCategoryService jobCategoryService;

    /*
     * Add a new job category
     */
    @PostMapping
    public ResponseEntity<JobCategory> addJobCategory(@RequestBody JobCategory jobCategory) {
        JobCategory newJobCategory = jobCategoryService.addJobCategory(jobCategory);
        return ResponseEntity.ok(newJobCategory);  // Return the newly added job category
    }

    /*
     * Update an existing job category
     */

    @PutMapping("/{id}")
    public ResponseEntity<JobCategory> updateJobCategory(@PathVariable Long id, @RequestBody JobCategory jobCategory) {
        jobCategory.setId(id);
        JobCategory updatedJobCategory = jobCategoryService.updateJobCategory(jobCategory);
        return ResponseEntity.ok(updatedJobCategory);  // Return the updated job category
    }

    /*
     * Get all job categories
     */
    @GetMapping
    public ResponseEntity<List<JobCategory>> getAllJobCategories() {
        List<JobCategory> jobCategories = jobCategoryService.getAllJobCategories();
        return ResponseEntity.ok(jobCategories);  // Return the list of job categories
    }

    /*
     * Delete a job category
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobCategory(@PathVariable Long id) {
        jobCategoryService.deleteJobCategory(id);  // Delete job category by ID
        return ResponseEntity.noContent().build();  // Return no content response (204)
    }
}
