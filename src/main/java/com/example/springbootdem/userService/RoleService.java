package com.example.springbootdem.userService;



import com.example.springbootdem.model.Role;

import java.util.List;

public interface RoleService {

    void save(Role role);

    void update(Role updatedRole);

    Role getRoleById(Integer id);

    void delete(Integer id);

    List<Role> getDemandedRoles();
}
