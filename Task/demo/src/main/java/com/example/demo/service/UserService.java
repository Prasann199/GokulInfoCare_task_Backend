package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.model.UserData;

public interface UserService {

	void addUser(UserData data);

	List<User> getUser();

	void deleteUser(String email);

	void updateUser(String email,UserData data);

	User getUserByEmail(String email);

	

	

}
