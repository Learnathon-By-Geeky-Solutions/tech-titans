package Job.Portal.System.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;  // Title of the job

    @Column(columnDefinition = "TEXT")
    private String description;  // Description of the job

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Employee company;  // Reference to the company offering the job

    @ManyToOne
    @JoinColumn(name = "category_id")
    private JobCategory category;  // Reference to the job category
}
