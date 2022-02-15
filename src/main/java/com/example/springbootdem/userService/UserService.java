package com.example.springbootdem.userService;


import com.example.springbootdem.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void update(User updatedUser);

    User getUserById(Integer id);

    void delete(Integer id);

    List<User> getDemandedUsers();

    User findByUsername(String username);

    User setRolesToUser(User user, int[] rolesIdArr);

    void setEncryptedPassword(User user);
}
