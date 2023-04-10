package com.dambroski.foodDeliveryProject.User;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dambroski.foodDeliveryProject.Address.Address;

public interface UserService {

	List<User> getAll();

	User getUserById(Long id);

	List<User> getUserByName(String name);

	User getUserByEmail(String email);

	User postUser(User user);

	void deleteById(Long id);

	User editUser(User user, Long id);

	User postUserRestaurant(User user);

	User postUserDelivery(User user);

	User postUserAdmin(User user);

	User addAddress(Address address, Long userId);

	User editAddress(Address address, Long userId, Long addressId);



}
