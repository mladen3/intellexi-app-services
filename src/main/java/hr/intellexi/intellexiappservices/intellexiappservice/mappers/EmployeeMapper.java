package hr.intellexi.intellexiappservices.intellexiappservice.mappers;

import hr.intellexi.intellexiappservices.intellexiappservice.domain.Employee;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EmployeeDto;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    EmployeeDto EmployeeToEmployeeDto(Employee employee);

    Employee EmployeeDtoToEmployee(EmployeeDto employeeDto);
}
