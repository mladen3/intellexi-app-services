package hr.intellexi.intellexiappservices.intellexiappservice.web.services.impl;

import hr.intellexi.intellexiappservices.intellexiappservice.web.model.User;
import hr.intellexi.intellexiappservices.intellexiappservice.web.repositories.UserRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
