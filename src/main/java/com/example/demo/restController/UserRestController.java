package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	UserService service;

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return service.findAllUsers();
	}

}
