package com.example.springbootdem.controller;

import com.example.springbootdem.model.User;
import com.example.springbootdem.userService.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class UserController {

    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public void setUserDetailsServiceImp(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @GetMapping("/user")
    public String pageForUsers(Principal principal, Model model) {
        User user = userDetailsServiceImpl.findByUsername(principal.getName());
        model.addAttribute(user);
        return "userForm";
    }
}