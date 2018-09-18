package com.artivistas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.artivistas.model.User;
import com.artivistas.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody User getAllUsers(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	/*@RequestMapping(value = "/userByName/{login}", method = RequestMethod.GET)
	public User getUserByLogin(@PathVariable String login) {
		return userService.findByLogin(login);
	}*/
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> getAll() {
		return userService.getAllUsers();
	}
	

}
