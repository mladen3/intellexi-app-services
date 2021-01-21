package hr.intellexi.intellexiappservices.intellexiappservice.web.bootstrap;

import hr.intellexi.intellexiappservices.intellexiappservice.web.config.UserHelper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.User;
import hr.intellexi.intellexiappservices.intellexiappservice.web.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserHelper userHelper;

    public UserLoader(UserRepository userRepository, UserHelper userHelper) {
        this.userRepository = userRepository;
        this.userHelper = userHelper;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User((long) 4, "mujo", userHelper.encodePassword("sifra123"), "admin");
        this.userRepository.save(u1);
    }
}
