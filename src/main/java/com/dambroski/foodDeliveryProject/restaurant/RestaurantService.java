package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;

public interface RestaurantService {

	List<Restaurant> getAllRestaurant();

	Restaurant postRestaurant(Restaurant restaurant);

	Restaurant putRestaurant(Restaurant restaurant, Long id);

	void deleteById(Long id);

}
