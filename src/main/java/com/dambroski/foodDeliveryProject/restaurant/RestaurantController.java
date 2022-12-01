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

import lombok.Delegate;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService service;
	
	@GetMapping("/getAll")
	public List<Restaurant> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/post")
	public Restaurant postRestaurant(@RequestBody Restaurant restaurant){
		return service.post(restaurant);
	}
	
	@PutMapping("/put/{restaurantId}")
	public Restaurant putRestaurant(@RequestBody Restaurant restaurant,@PathVariable("restaurantId") Long restaurantId ) {
		return service.putRestaurant(restaurant,restaurantId);
	}
	
	@DeleteMapping("/delete/{restaurantId}")
	public void deleteResturantById(@PathVariable("restaurantId")Long restaurantId) {
		 service.deleteById(restaurantId);
	}
}
