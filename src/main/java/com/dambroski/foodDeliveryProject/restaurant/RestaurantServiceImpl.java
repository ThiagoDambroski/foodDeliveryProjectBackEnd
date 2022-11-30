package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.foodDeliveryProject.User.UserRepository;
import com.dambroski.foodDeliveryProject.food.Food;
import com.dambroski.foodDeliveryProject.food.FoodRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	RestaurantRepository repository;
	
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Restaurant> getAllRestaurant() {
		
		return repository.findAll();
	}

	@Override
	public Restaurant postRestaurant(Restaurant restaurant,Long userId) {
		restaurant.setUser(userRepository.findById(userId).get());
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

	@Override
	public Restaurant getById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	
	
	
	

}
