package hr.intellexi.intellexiappservices.intellexiappservice.web.services;

import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EmployeeDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.auth.AuthRequest;

import java.util.List;

public interface EmployeeService {

    EmployeeDto getEmployeeById(long id);

    void deleteById(long id);

    AuthRequest saveEmployee(EmployeeDto employeeDto);

    void updateEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> findAll();

    List<EmployeeDto> findAll(int page, int size);

    Integer getNumberOfEmployeesWithFirstName(String firstName);
}
