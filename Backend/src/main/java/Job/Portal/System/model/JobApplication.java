package Job.Portal.System.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;



@Data
@Entity
@Table(name = "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for the job application

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private User jobSeeker;  // Reference to the user (job seeker) who applied

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;  // Reference to the job for which the application was made

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;  // Status of the application (default is PENDING)

    @Column(name = "application_date")
    private LocalDateTime applicationDate = LocalDateTime.now();  // Date and time when the application was made

    /**
     * Enum representing the status of a job application.
     */
    public enum Status {
        PENDING, ACCEPTED, REJECTED
    }
}
