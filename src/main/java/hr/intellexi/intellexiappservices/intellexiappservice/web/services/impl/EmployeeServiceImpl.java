package hr.intellexi.intellexiappservices.intellexiappservice.web.services.impl;

import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Employee;
import hr.intellexi.intellexiappservices.intellexiappservice.web.mappers.EmployeeMapper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.auth.AuthRequest;
import hr.intellexi.intellexiappservices.intellexiappservice.web.repositories.EmployeeRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EmployeeDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hr.intellexi.intellexiappservices.intellexiappservice.web.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final UserService userService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeMapper employeeMapper,
                               UserService userService) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.userService = userService;
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        log.info("Getting employee with ID: " + id);

        Employee employee = employeeRepository.findById(id).orElse(new Employee());

        return employeeMapper.EmployeeToEmployeeDto(employee);

    }

    @Override
    public void deleteById(long id) {
        log.info("Deleting employee with ID: " + id);
        employeeRepository.deleteById(id);
    }

    @Override
    public AuthRequest saveEmployee(EmployeeDto employeeDto) {
        log.info("Saving employee: " + employeeDto.toString());

        Employee employeeSaved =
                employeeRepository.save(employeeMapper.EmployeeDtoToEmployee(employeeDto));

//        return employeeMapper.EmployeeToEmployeeDto(employeeSaved);
        Integer numberOfFirstNames = this.getNumberOfEmployeesWithFirstName(employeeSaved.getFirstName());
        return userService.createCredentialsForEmployee(employeeSaved, numberOfFirstNames);
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        log.info("Updating employee: " + employeeDto.toString());

        employeeRepository.save(employeeMapper.EmployeeDtoToEmployee(employeeDto));
    }

    @Override
    public List<EmployeeDto> findAll() {

        Iterable<Employee> iterable = employeeRepository.findAll();
        List<EmployeeDto> listToReturn = new ArrayList<>();

        iterable.forEach(item ->
                listToReturn.add(employeeMapper.EmployeeToEmployeeDto(item)));

        log.info("findAll method returning: " + listToReturn.size() + " entities.");

        return listToReturn;
    }

    @Override
    public List<EmployeeDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return employeeRepository.findAll(pageable).getContent().stream()
                .map(employeeMapper::EmployeeToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNumberOfEmployeesWithFirstName(String firstName) {
        return employeeRepository.getNumberOfEmployeesWithFirstName(firstName);
    }
}
