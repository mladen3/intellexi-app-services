package hr.intellexi.intellexiappservices.intellexiappservice.web.controllers;

import hr.intellexi.intellexiappservices.intellexiappservice.web.helpers.JwtHelper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.auth.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/v1/login")
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private JwtHelper jwtHelper;
    private AuthenticationManager authenticationManager;

    public LoginController(JwtHelper jwtHelper, AuthenticationManager authenticationManager) {
        this.jwtHelper = jwtHelper;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public String generateToken(@RequestBody AuthRequest authRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                        authRequest.getPassword()));

        return jwtHelper.generateToken(authRequest.getUsername());
    }
}
