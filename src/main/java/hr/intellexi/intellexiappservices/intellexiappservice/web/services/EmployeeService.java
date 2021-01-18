package hr.intellexi.intellexiappservices.intellexiappservice.web.services;

import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto getEmployeeById(long id);

    void deleteById(long id);

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    void updateEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> findAll();

    List<EmployeeDto> findAll(int page, int size);
}
