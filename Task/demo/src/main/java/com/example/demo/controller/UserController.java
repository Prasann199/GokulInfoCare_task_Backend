package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.model.UserData;
import com.example.demo.service.UserService;
@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;
	
//	End point for Adding Users to Database
	@PostMapping("/adduser")
	public String addUser(@RequestBody UserData data) {
		userService.addUser(data);
		return "user added";
	}
//	Getting all the User to show in page list of Users
	@GetMapping("/getuser")
	public List<User> getUser(){
		return userService.getUser();
	}
//	Deleting Users by their email
	@DeleteMapping("/delete/{email}")
	public String deleteUser(@PathVariable String email) {
		userService.deleteUser(email);
		return "user deleted";
	}
//	updating user By their email
	@PostMapping("/update/{email}")
	public String update(@PathVariable String email,@RequestBody UserData data) {
		userService.updateUser(email,data);
		return "user updated";
	}
//	Getting User by email
	@GetMapping("/getuser/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
	
	
}
