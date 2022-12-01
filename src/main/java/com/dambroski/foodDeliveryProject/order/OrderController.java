package com.dambroski.foodDeliveryProject.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@GetMapping("/getAll")
	public List<Order> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/post/{userId}")
	public Order postOrder(@RequestBody Order order,@PathVariable("userId") Long userId) throws Exception {
		return service.post(order,userId);
	}
}
