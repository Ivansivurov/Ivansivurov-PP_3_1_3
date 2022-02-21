package com.example.springbootdem.controller;

import com.example.springbootdem.model.Role;
import com.example.springbootdem.model.User;
import com.example.springbootdem.userService.RoleService;
import com.example.springbootdem.userService.UserDetailsServiceImpl;
import com.example.springbootdem.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public void setUserDetailsServiceImp(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/admin/users")
    public String getUsers(Model model, Principal principal) {
        model.addAttribute("keyValue", userService.getDemandedUsers());
        model.addAttribute("user1", userDetailsServiceImpl.findByUsername(principal.getName()));
        model.addAttribute("user", new User());
        model.addAttribute("rolesList", roleService.getDemandedRoles());

        return "usersView";
    }

    @PostMapping("/admin/users")
    public String create(@ModelAttribute("user") User user,
                         @RequestParam(value = "rolesIdArr", required = false) int[] rolesIdArr) {
        if (rolesIdArr[0] == 2){
            rolesIdArr = new int[] {1, 2};
        }
        User updatedUser = userService.setRolesToUser(user, rolesIdArr);
        userService.save(updatedUser);

        return "redirect:/admin/users/";
    }

    @PatchMapping("/admin/users/edit")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam(value = "rolesIdArr", required = false) int[] rolesIdArr) {
        if (rolesIdArr[0] == 2){
            rolesIdArr = new int[] {1, 2};
        }
        User updatedUser = userService.setRolesToUser(user, rolesIdArr);
        userService.update(updatedUser);
        return "redirect:/admin/users/";
    }

    @DeleteMapping("/admin/users/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/admin/users/";
    }
}