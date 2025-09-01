package Job.Portal.System.repository;

import Job.Portal.System.model.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory, Long> {


    /**
     * Find a job category by its name.
     */

    JobCategory findByName(String name);

}
