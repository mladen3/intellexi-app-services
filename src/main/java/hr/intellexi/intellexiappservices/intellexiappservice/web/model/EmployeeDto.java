package hr.intellexi.intellexiappservices.intellexiappservice.web.model;

import hr.intellexi.intellexiappservices.intellexiappservice.web.model.enums.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private LocalDateTime firstDayInCompany;
    private Float yearOfExperience;
    private Boolean managingProject;
    private Long managedBy;
    private EmployeeType employeeType;

}
