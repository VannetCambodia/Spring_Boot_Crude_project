package com.example.crud_docker;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CrudDockerApplication {

    private static final Logger log = LoggerFactory.getLogger(CrudDockerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrudDockerApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<Users> getUsers() {
        Users user = new Users();
        user.setName("Vannet");
        user.setEmail("vannet.veng@abc.com.kh");

        log.trace(user.toString());
        userRepository.save(user);

        return userRepository.findAll();
    }
}
