package com.example.demo.services;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}
