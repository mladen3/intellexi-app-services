package hr.intellexi.intellexiappservices.intellexiappservice.web.services;

import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Employee;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.User;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.auth.AuthRequest;

public interface UserService {

    void saveUser(User user);
    AuthRequest createCredentialsForEmployee(Employee employee, Integer numberOfFirstNames);
}
