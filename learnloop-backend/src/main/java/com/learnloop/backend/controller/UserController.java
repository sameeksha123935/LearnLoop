package com.learnloop.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.learnloop.backend.model.User;
import com.learnloop.backend.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Allow frontend connection
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ✅ Test Endpoint
    @GetMapping("/")
    public String home() {
        return "Hello! Your Spring Boot + MySQL app is working 🎉";
    }

    // ✅ SIGNUP API (Fixed: added @RequestBody + password check)
    @PostMapping(value = "/signup", consumes = { "application/json", "application/x-www-form-urlencoded" })
    public ResponseEntity<String> signup(@RequestBody User user) {
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("⚠️ Email already registered!");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("⚠️ Password cannot be empty!");
        }

        userRepository.save(user);
        return ResponseEntity.ok("✅ User registered successfully!");
    }

    // ✅ LOGIN API (Fixed: added @RequestBody + null check)
    @PostMapping(value = "/login", consumes = { "application/json", "application/x-www-form-urlencoded" })
    public ResponseEntity<String> login(@RequestBody User loginUser) {
        User existingUser = userRepository.findByEmail(loginUser.getEmail());

        if (existingUser == null) {
            return ResponseEntity.status(401).body("❌ User not found!");
        }

        // Prevent NullPointerException
        if (existingUser.getPassword() != null &&
                existingUser.getPassword().equals(loginUser.getPassword())) {
            return ResponseEntity.ok("✅ Login Successful!");
        } else {
            return ResponseEntity.status(401).body("❌ Invalid Credentials!");
        }
    }

    // ✅ Fetch all users (for testing)
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
