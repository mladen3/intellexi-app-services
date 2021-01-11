package hr.intellexi.intellexiappservices.intellexiappservice.utils;

import hr.intellexi.intellexiappservices.intellexiappservice.domain.Employee;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EmployeeDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.enums.EmployeeType;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class EmployeeHelper {

    public static EmployeeDto getTestEmployee() {
        return EmployeeDto.builder()
                .id(12345L)
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

    public static List<Employee> getTestEmployeeList() {
        List<Employee> listToReturn = new ArrayList<>();

        listToReturn.add(Employee.builder()
                .firstName("Jay Jay")
                .lastName("Okocha")
                .dateOfBirth(LocalDateTime.now().minusYears(30L))
                .yearsOfExperience(2.5f)
                .employeeType(EmployeeType.STUDENT)
                .managedBy(22L)
                .managingProject(true)
                .firstDayInCompany(LocalDateTime.of(1990, Month.NOVEMBER, 1, 0 ,0))
                .build());

        listToReturn.add(Employee.builder()
                .firstName("Rik")
                .lastName("Smits")
                .dateOfBirth(LocalDateTime.now().minusYears(44L))
                .yearsOfExperience(22.5f)
                .employeeType(EmployeeType.PARTTIME)
                .managedBy(133L)
                .managingProject(false)
                .firstDayInCompany(LocalDateTime.of(2011, Month.DECEMBER, 1, 0 ,0))
                .build());

        listToReturn.add(Employee.builder()
                .firstName("Jimmy Floyd")
                .lastName("Hasselbaink")
                .dateOfBirth(LocalDateTime.now().minusYears(43L))
                .yearsOfExperience(11.5f)
                .employeeType(EmployeeType.FULLTIME)
                .managedBy(12L)
                .managingProject(true)
                .firstDayInCompany(LocalDateTime.of(1998, Month.JANUARY, 1, 0 ,0))
                .build());

        return listToReturn;
    }


}
