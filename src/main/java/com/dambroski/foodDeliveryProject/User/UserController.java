package com.dambroski.foodDeliveryProject.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/getAll")
	public List<User> getAllUsers(){
		return service.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return service.getUserById(id);
	}
	
	@PostMapping("/post")
	public User postUser(@RequestBody User user) {
		return service.postUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
	
	@PutMapping("/edit/{id}")
	public User editUser(@PathVariable("id")Long id, @RequestBody User user) {
		return service.editUser(user,id);
	}
	
	@GetMapping("/test")
	public String test() {
		return "sucess";
	}
	

}