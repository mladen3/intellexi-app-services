package hr.intellexi.intellexiappservices.intellexiappservice.repositories;


import hr.intellexi.intellexiappservices.intellexiappservice.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
