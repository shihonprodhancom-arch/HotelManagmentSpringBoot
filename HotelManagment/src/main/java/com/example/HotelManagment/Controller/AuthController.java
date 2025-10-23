package com.example.HotelManagment.Controller;

import com.example.HotelManagment.Entity.User;
import com.example.HotelManagment.Repository.UserRepository;
import com.example.HotelManagment.Security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    // Registration
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        }
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // Login
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
//        String email = request.get("email");
//        String password = request.get("password");
//
//        Optional<User> user = userRepository.findByEmail(email);
//        if(user.isPresent() && user.get().getPassword().equals(password)) {
//            String token = jwtUtil.generateToken(email);
//            Map<String, String> response = new HashMap<>();
//            response.put("token", token);
//            response.put("message", "Login successful");
//            return ResponseEntity.ok(response);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> request){
        String email = request.get("email");
        String password = request.get("password");

        // Hardcoded test
        if("test@gmail.com".equals(email) && "123456".equals(password)) {
            String token = jwtUtil.generateToken(email);
            Map<String,String> res = new HashMap<>();
            res.put("token", token);
            res.put("message", "Login successful");
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
