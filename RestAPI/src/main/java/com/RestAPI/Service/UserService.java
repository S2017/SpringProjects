package com.RestAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPI.Model.User;
import com.RestAPI.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepository;
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}	
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}	
	
	public void updateUser(User user) {
		User existingUser = userRepository.getById(user.getId());
		
		existingUser.setId(user.getId());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setAge(user.getAge());
		
		userRepository.save(existingUser);
	}
		
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
		return "User::" +id+ "deleted from DB";
	}
}
