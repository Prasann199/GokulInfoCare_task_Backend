package com.example.demo.serviceimpl;

import java.util.List;

//Main logics are here for the working

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.model.UserData;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
//	Adding User
	@Override
	public void addUser(UserData data) {
//		creating new User
		User user=new User();
//		setting User data by getting data which is been sent from frontend 
		user.setFname(data.getFname());
		user.setLname(data.getLname());
		user.setPno(data.getPno());
		user.setAddress(data.getAddress());
		user.setEmail(data.getEmail());
//		Saving the user in Database
		userRepository.save(user);
		
	}
//	Getting all user Data
	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(String email) {
//		User is been finding by email
		User user=userRepository.findByEmail(email);
//		Deleting User
		userRepository.delete(user);
		
	}
//	Updating User Data
	@Override
	public void updateUser(String email,UserData data) {
		// TODO Auto-generated method stub
//		User is been finding using email
		User user=userRepository.findByEmail(email);
//		adding the new data sent from frontend
		user.setFname(data.getFname());
		user.setLname(data.getLname());
		user.setPno(data.getPno());
		user.setAddress(data.getAddress());
		user.setEmail(data.getEmail());
		userRepository.save(user);
		
	}
//	getting User BY email

	@Override
	public User getUserByEmail(String email) {
		User user=userRepository.findByEmail(email);
		return user;
	}

	

	
}
