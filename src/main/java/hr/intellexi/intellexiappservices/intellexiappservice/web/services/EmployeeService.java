package hr.intellexi.intellexiappservices.intellexiappservice.web.services;

import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EmployeeDto;

public interface EmployeeService {

    EmployeeDto getEmployeeById(long id);

    void deleteById(long id);

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    void updateEmployee(EmployeeDto employeeDto);
}
