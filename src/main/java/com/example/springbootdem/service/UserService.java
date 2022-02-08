package com.example.springbootdem.service;

import com.example.springbootdem.model.User;
import java.util.List;

public interface UserService {
    List<User> index();
    void save(User user);
    User getUser(int id);
    void update(int id, User user);
    void delete(int id);
}
