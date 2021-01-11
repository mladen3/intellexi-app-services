package hr.intellexi.intellexiappservices.intellexiappservice.bootstrap;

import hr.intellexi.intellexiappservices.intellexiappservice.repositories.EmployeeRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.utils.EmployeeHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public EmployeeLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadEmployees();
    }

    private void loadEmployees() {
        if (employeeRepository.count() == 0) {
            EmployeeHelper.getTestEmployeeList().stream()
                    .forEach(employeeDto -> employeeRepository.save(employeeDto));
        }
    }
}
