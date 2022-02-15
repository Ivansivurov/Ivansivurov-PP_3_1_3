package com.example.springbootdem.util;

import com.example.springbootdem.model.Role;
import com.example.springbootdem.model.User;
import com.example.springbootdem.userService.RoleService;
import com.example.springbootdem.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class InitialDataRunner implements CommandLineRunner {


    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) {
        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");
        roleService.save(role1);
        roleService.save(role2);
        List<Role> u1roles = new ArrayList<>();
        u1roles.add(role2);
        User user1 = new User("admin", "admin", null, null, "admin", u1roles);
        User user2 = new User("user", "user", null, null, "user", u1roles);

        userService.save(user1);
        userService.save(user2);
    }
}
