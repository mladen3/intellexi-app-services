package hr.intellexi.intellexiappservices.intellexiappservice.repositories;

import hr.intellexi.intellexiappservices.intellexiappservice.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
