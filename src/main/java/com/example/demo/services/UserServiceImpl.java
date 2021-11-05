package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repo.RoleRepository;
import com.example.demo.repo.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	//pour la cryptage des donnees
	@Autowired
	BCryptPasswordEncoder  bCryptPasswordEncoder ;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public User addRoleToUser(String username, String rolename) {
		User user=userRepository.findByUsername(username);
		Role role =roleRepository.findByRole(rolename);
		
		user.getRoles().add(role);
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
