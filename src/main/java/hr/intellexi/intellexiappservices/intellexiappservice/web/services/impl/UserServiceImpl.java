package hr.intellexi.intellexiappservices.intellexiappservice.web.services.impl;

import hr.intellexi.intellexiappservices.intellexiappservice.web.config.UserHelper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Employee;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.User;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.auth.AuthRequest;
import hr.intellexi.intellexiappservices.intellexiappservice.web.repositories.UserRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.EmployeeService;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private UserRepository userRepository;

    private UserHelper userHelper;

    public UserServiceImpl(UserRepository userRepository, UserHelper userHelper) {
        this.userRepository = userRepository;
        this.userHelper = userHelper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(s);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    @Override
    public void saveUser(User user) {
        if (this.userRepository.findUserByUsername(user.getUsername()) == null) {
            this.userRepository.save(user);
        } else {
            System.out.println("Already saved user with that username");
        }
    }

    public AuthRequest createCredentialsForEmployee(Employee employee, Integer numberOfFirstNames) {
        String username = employee.getFirstName() + numberOfFirstNames;
        String password = this.userHelper.generateSecureRandomPassword();
        String hashiraniPassword = this.userHelper.encodePassword(password);
        User user = new User(employee.getId(), username, hashiraniPassword, "employee");
        this.saveUser(user);
        return new AuthRequest(username, password);
    }
}
