package com.dambroski.foodDeliveryProject.food;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	FoodRepository repository;

	@Override
	public List<Food> getAllFoods() {
	
		return repository.findAll();
	}

	@Override
	public Food postFood(Food food) {
		return repository.save(food);
	}

	@Override
	public Food putFood(Food food, Long id) {
		Food newFood = repository.findById(id).get();
		if(Objects.nonNull(food.getName()) && !"".equals(food.getName())) {
			newFood.setName(food.getName());
		}
		if(Objects.nonNull(food.getDescription())) {
			newFood.setDescription(food.getDescription());
		}
		newFood.setPrice(food.getPrice());
		newFood.setCategory(food.getCategory());
		newFood.setStock(food.getStock());
		return repository.save(newFood);
		
		
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Food> getFoodByName(String name) {
		// TODO Auto-generated method stub
		return repository.getFoodByName(name);
	}

	@Override
	public List<Food> getFoodByCategory(String category) {
		// TODO Auto-generated method stub
		return repository.getFoodByCategory(category);
	}

}
