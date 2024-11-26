package com.example.todo.service;

import com.example.todo.dao.UserRepo;
import com.example.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public ResponseEntity<String> registerUser(User user){
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            userRepo.save(user);
            return new ResponseEntity<>("User registration was successful", HttpStatus.CREATED);
        }catch (Exception e){
        }
        return new ResponseEntity<>("Bad request, User is not successfully registered",HttpStatus.BAD_REQUEST);

    }
}
