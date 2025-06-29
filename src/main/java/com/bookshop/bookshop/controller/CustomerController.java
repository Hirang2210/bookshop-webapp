package com.bookshop.bookshop.controller;

import com.bookshop.bookshop.model.Role;
import com.bookshop.bookshop.model.User;
import com.bookshop.bookshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Serve the registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Handle form submission from register.html
    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("user") User user, Model model) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already registered.");
            return "register";
        }

        user.setRole(Role.CUSTOMER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        model.addAttribute("message", "Registration successful. Please login.");
        return "redirect:/login";
    }

    // Optional: REST-style endpoint to fetch profile
    @ResponseBody
    @GetMapping("/customer/profile/{email}")
    public User getCustomerProfile(@PathVariable String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}



