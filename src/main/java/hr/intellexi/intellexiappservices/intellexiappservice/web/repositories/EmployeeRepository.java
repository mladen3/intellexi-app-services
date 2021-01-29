package hr.intellexi.intellexiappservices.intellexiappservice.web.repositories;

import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Query(
            value = "select count(e.id) from Employee e where e.firstName = :firstName"
    )
    Integer getNumberOfEmployeesWithFirstName(@Param("firstName") String firstName);
}
