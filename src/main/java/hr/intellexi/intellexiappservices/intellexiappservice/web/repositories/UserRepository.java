package hr.intellexi.intellexiappservices.intellexiappservice.web.repositories;

import hr.intellexi.intellexiappservices.intellexiappservice.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
