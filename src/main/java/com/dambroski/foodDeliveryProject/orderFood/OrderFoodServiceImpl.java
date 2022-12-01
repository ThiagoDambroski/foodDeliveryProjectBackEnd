package com.dambroski.foodDeliveryProject.orderFood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFoodServiceImpl implements OrderFoodService{
	
	@Autowired
	OrderFoodRepository repository;

	@Override
	public List<OrderFood> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public OrderFood postOrderFood(OrderFood orderFood) {
		// TODO Auto-generated method stub
		return repository.save(orderFood);
	}

}
