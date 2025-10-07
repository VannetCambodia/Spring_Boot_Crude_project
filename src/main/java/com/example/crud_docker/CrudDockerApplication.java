package com.example.crud_docker;

import jakarta.annotation.PostConstruct;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class CrudDockerApplication {

    private static final Logger log = LoggerFactory.getLogger(CrudDockerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrudDockerApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }
}
