package hr.intellexi.intellexiappservices.intellexiappservice.web.repositories;

import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
