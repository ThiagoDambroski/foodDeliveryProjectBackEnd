package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;

import com.dambroski.foodDeliveryProject.Address.Address;

public interface RestaurantService {

	List<Restaurant> getAll();

	Restaurant post(Restaurant restaurant);

	void deleteById(Long restaurantId);

	Restaurant putRestaurant(Restaurant restaurant, Long restaurantId);

	Restaurant addRestaurant(Address address, Long restaurantId);

}
