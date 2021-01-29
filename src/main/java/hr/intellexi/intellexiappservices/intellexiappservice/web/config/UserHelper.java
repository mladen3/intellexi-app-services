package hr.intellexi.intellexiappservices.intellexiappservice.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class UserHelper {

    public String encodePassword(String password) {
        return passwordEncoder().encode(password);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Stream<Character> getRandomChars(int count, int lowerAsciiBound, int upperAsciiBound) {
        Random random = new SecureRandom();
        IntStream specialChars = random.ints(count, lowerAsciiBound, upperAsciiBound);
        return specialChars.mapToObj(data -> (char) data);
    }

    public String generateSecureRandomPassword() {
        Stream<Character> pwdStream = Stream.concat(getRandomChars(2, 48, 57),
                Stream.concat(getRandomChars(2, 33, 45),
                        Stream.concat(getRandomChars(2, 65, 90), getRandomChars(4, 97, 122))));
        List<Character> charList = pwdStream.collect(Collectors.toList());
        Collections.shuffle(charList);
        String password = charList.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return password;
    }

}
