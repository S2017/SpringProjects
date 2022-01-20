package com.RestAPI.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.Model.User;
import com.RestAPI.Service.UserService;

@RestController
public class RestApi {

	@Autowired
	private UserService userSvc; 
	
	@GetMapping("/")
	public List<User> getUsers() {
		return userSvc.getUsers();
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userSvc.saveUser(user);
	}
	
	@PutMapping("/update")
	public void updateUser(@RequestBody User user) {		
		userSvc.updateUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUserById(@PathVariable int id) {
		userSvc.deleteUserById(id);
		return "User::" +id+ "deleted from DB";
	}
	
}
