package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.dambroski.foodDeliveryProject.Address.Address;
import com.dambroski.foodDeliveryProject.Address.AddressRepository;
import com.dambroski.foodDeliveryProject.delivery.Delivery;
import com.dambroski.foodDeliveryProject.delivery.DeliveryRepository;
import com.dambroski.foodDeliveryProject.delivery.DeliveryStatus;
import com.dambroski.foodDeliveryProject.error.RestaurantNotFoundException;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepository repository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	DeliveryRepository deliveryRepository;	

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
		Optional<Restaurant> optionalRestaurant = repository.findById(restaurantId);
		if(optionalRestaurant.isEmpty()) {
			throw new RestaurantNotFoundException("restaurant Not Found");
		}
		
		repository.deleteById(restaurantId);
		
	}
	
	

	@Override
	public Restaurant putRestaurant(Restaurant restaurant, Long restaurantId) {
		Restaurant newRestaurant = repository.findById(restaurantId).get();
		
		if(Objects.nonNull(restaurant.getName()) && !"".equals(restaurant.getName())) {
			newRestaurant.setName(restaurant.getName());
		}
		if(Objects.nonNull(restaurant.getDescription()) && !"".equals(restaurant.getDescription())) {
			newRestaurant.setDescription(restaurant.getDescription());
		}
		
	
		repository.save(newRestaurant);
		return newRestaurant;
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

	@Override
	public Restaurant getById(Long restaurantId) {
		// TODO Auto-generated method stub
		return repository.findById(restaurantId).get();
	}

	@Override
	public Delivery aproveDelivery(Long deliveryId, Long restarauntId) {
		Restaurant restaurant = repository.findById(restarauntId).get();
		Delivery delivery = deliveryRepository.findById(deliveryId).get();
		if(delivery.getOrder().getRestaurant() == restaurant) {
			delivery.setStatus(DeliveryStatus.COOKING);
			deliveryRepository.save(delivery);
		}else {
			throw new BadCredentialsException("Restaurant or delivery code incorrect");
		}
		
		return delivery;
	}

}
