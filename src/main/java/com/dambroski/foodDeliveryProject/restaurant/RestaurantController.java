package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
