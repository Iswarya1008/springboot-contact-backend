package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000", "http://localhost:8080"})
@RestController
@RequestMapping("/api/contact")

public class contoller {
    @Autowired
    private service emailService;

    @GetMapping("/")
    public String home() {
        return "✅ Backend is running fine on /api/contact";
    }

    @PostMapping(value ={"", "/"})
    public ResponseEntity<String> sendContact(@Valid @RequestBody model request) {
        emailService.sendContactMail(request);
        return ResponseEntity.ok("Enquiry sent successfully!");
    }
}
