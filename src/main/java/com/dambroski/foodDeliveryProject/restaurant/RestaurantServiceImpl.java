package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.foodDeliveryProject.Address.Address;
import com.dambroski.foodDeliveryProject.Address.AddressRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepository repository;
	
	@Autowired
	AddressRepository addressRepository;

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

	@Override
	public Restaurant addRestaurant(Address address, Long restaurantId) {
		Restaurant restaurant = repository.findById(restaurantId).get();
		address.setType("RESTAURANT");
		address.setTypeId(restaurantId);
		addressRepository.save(address);
		restaurant.setAddress(address);
		return repository.save(restaurant);
	}

}
