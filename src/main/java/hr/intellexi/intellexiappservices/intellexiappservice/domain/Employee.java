package hr.intellexi.intellexiappservices.intellexiappservice.domain;

import hr.intellexi.intellexiappservices.intellexiappservice.web.model.enums.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(generator="sequence_generator")
    @GenericGenerator(name="sequence_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private LocalDateTime dateOfBirth;
    @Column
    private LocalDateTime firstDayInCompany;
    @Column
    private float yearsOfExperience;
    @Column
    private Boolean managingProject;
    @Column
    private Long managedBy;
    @Column
    private EmployeeType employeeType;
}
