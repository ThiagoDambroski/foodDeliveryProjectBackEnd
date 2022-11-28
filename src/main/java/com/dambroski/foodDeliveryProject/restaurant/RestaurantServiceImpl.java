package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	RestaurantRepository repository;

	@Override
	public List<Restaurant> getAllRestaurant() {
		
		return repository.findAll();
	}

	@Override
	public Restaurant postRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return repository.save(restaurant);
	}

	@Override
	public Restaurant putRestaurant(Restaurant restaurant, Long id) {
		Restaurant newRestaurant = repository.findById(id).get();
		
		if(Objects.nonNull(restaurant.getName()) && !"".equals(restaurant.getName())) {
			newRestaurant.setName(restaurant.getName());
		}
		newRestaurant.setDescription(restaurant.getDescription());
		
		if(Objects.nonNull(restaurant.getType())) {
			newRestaurant.setType(restaurant.getType());
		}
		
		newRestaurant.setFoods(restaurant.getFoods());
		
		// TODO Auto-generated method stub
		return repository.save(newRestaurant);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}
	
	
	

}
