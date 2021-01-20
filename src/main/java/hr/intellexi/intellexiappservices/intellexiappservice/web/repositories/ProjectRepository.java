package hr.intellexi.intellexiappservices.intellexiappservice.web.repositories;

import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
