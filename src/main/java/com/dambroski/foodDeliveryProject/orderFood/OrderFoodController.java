package com.dambroski.foodDeliveryProject.orderFood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderFood")
public class OrderFoodController {
	
	@Autowired
	OrderFoodService service;
	
	
	@GetMapping("/getAll")
	public List<OrderFood> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/post")
	public OrderFood postOrderFood(@RequestBody OrderFood orderFood) {
		return service.postOrderFood(orderFood);
	}
	
	

}
