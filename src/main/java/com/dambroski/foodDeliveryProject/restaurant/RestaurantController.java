package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService service;
	
	@GetMapping("/getAll")
	public List<Restaurant> getAllRestaurant(){
		return service.getAllRestaurant();
	}
	
	@GetMapping("/getById/{id}")
	public Restaurant getRestaurantById(@PathVariable(name = "id") Long id) {
		return service.getById(id);
	}
	
	@PostMapping("/post/{userId}")
	public Restaurant postRestaurant(@RequestBody Restaurant restaurant,@PathVariable(name = "userId") Long userId) {
		return service.postRestaurant(restaurant,userId);
	}
	

	
	
	@PutMapping("put/{id}")
	public Restaurant putRestaurant(@RequestBody Restaurant restaurant, @PathVariable("id") Long id) {
		return service.putRestaurant(restaurant,id);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteRestaurant(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
}
