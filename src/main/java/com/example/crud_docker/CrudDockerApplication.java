package com.example.crud_docker;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CrudDockerApplication {

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

        userRepository.save(user);

        return userRepository.findAll();
    }
}
