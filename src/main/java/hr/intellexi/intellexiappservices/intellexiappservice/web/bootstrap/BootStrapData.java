package hr.intellexi.intellexiappservices.intellexiappservice.web.bootstrap;

import hr.intellexi.intellexiappservices.intellexiappservice.web.model.User;
import hr.intellexi.intellexiappservices.intellexiappservice.web.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final UserRepository userRepository;

    public BootStrapData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("mujo", "sifra123", "admin");
        this.userRepository.save(u1);
    }
}
