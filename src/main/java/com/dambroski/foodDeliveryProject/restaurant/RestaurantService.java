package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;

public interface RestaurantService {

	List<Restaurant> getAll();

	Restaurant post(Restaurant restaurant);

	void deleteById(Long restaurantId);

	Restaurant putRestaurant(Restaurant restaurant, Long restaurantId);

}
