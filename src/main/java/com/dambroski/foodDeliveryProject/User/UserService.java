package com.dambroski.foodDeliveryProject.User;

import java.util.List;

public interface UserService {

	List<User> getAll();

	User getUserById(Long id);

	User postUser(User user);

	void deleteById(Long id);

	User editUser(User user, Long id);

}
