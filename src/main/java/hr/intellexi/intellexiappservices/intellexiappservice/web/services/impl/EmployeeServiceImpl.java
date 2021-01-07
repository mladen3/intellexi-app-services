package hr.intellexi.intellexiappservices.intellexiappservice.web.services.impl;

import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EmployeeDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.enums.EmployeeType;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeDto getEmployeeById(long id) {
        log.info("Getting employee with ID: " + id);
        return EmployeeDto.builder()
                .id(id)
                .firstName("John")
                .lastName("Doe")
                .dateOfBirth(LocalDateTime.now().minusYears(30L))
                .yearsOfExperience(2.5f)
                .employeeType(EmployeeType.FULLTIME)
                .managedBy(123L)
                .managingProject(false)
                .firstDayInCompany(LocalDateTime.of(2018, Month.JANUARY, 1, 0 ,0))
                .build();
    }

    @Override
    public void deleteById(long id) {
        log.info("Deleting employee with ID: " + id);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        log.info("Saving employee: " + employeeDto.toString());

        return employeeDto;
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        log.info("Updating employee: " + employeeDto.toString());
    }
}
