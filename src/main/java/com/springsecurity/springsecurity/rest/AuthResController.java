package com.springsecurity.springsecurity.rest;

import com.springsecurity.springsecurity.exception.UserDuplicateException;
import com.springsecurity.springsecurity.model.AuthenticationRequest;
import com.springsecurity.springsecurity.model.User;
import com.springsecurity.springsecurity.reposity.UserRepository;
import com.springsecurity.springsecurity.service.CustomerUserDetailService;
import com.springsecurity.springsecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class AuthResController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomerUserDetailService customerUserDetailService;
    @Autowired
    private UserRepository userReposity;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User existingUser = userReposity.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new UserDuplicateException("Username : " + user.getUsername() + " already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userReposity.save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        final UserDetails userDetails = customerUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
        return jwtUtil.generateToken(userDetails);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
