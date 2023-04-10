package com.dambroski.foodDeliveryProject.orderFood;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.foodDeliveryProject.error.FoodNotFoundException;
import com.dambroski.foodDeliveryProject.food.Food;
import com.dambroski.foodDeliveryProject.food.FoodRepository;

@Service
public class OrderFoodServiceImpl implements OrderFoodService{
	
	@Autowired
	OrderFoodRepository repository;
	
	@Autowired
	FoodRepository foodRepository;

	@Override
	public List<OrderFood> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public OrderFood postOrderFood(OrderFood orderFood,Long foodId) {
		Optional<Food> optionalFood = foodRepository.findById(foodId);
		if(optionalFood.isEmpty()) {
			throw new FoodNotFoundException("Food not found");
		}
		Food food = optionalFood.get();
		orderFood.setFood(food);
		return repository.save(orderFood);
	}

}
