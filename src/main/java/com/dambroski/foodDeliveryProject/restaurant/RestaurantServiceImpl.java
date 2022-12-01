package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepository repository;

	@Override
	public List<Restaurant> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Restaurant post(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return repository.save(restaurant);
	}

	@Override
	public void deleteById(Long restaurantId) {
		repository.deleteById(restaurantId);
		
	}

	@Override
	public Restaurant putRestaurant(Restaurant restaurant, Long restaurantId) {
		Restaurant newRestaurant = repository.findById(restaurantId).get();
		
		newRestaurant.setName(restaurant.getName());
		newRestaurant.setDescription(restaurant.getDescription());
		
		return null;
	}

}
