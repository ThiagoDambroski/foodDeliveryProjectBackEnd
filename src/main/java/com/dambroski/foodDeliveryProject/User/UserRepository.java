package com.dambroski.foodDeliveryProject.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dambroski.foodDeliveryProject.food.Food;

public interface UserRepository extends JpaRepository<User, Long>{
	

	
	
	@Query("select u from User u where u.email = ?1")
	User findUserByEmail(String email);
	
	boolean existsByEmail(String email);
	
	
	@Query("select u from User u where u.name like '%'||:name||'%' ")
	List<User> getUserByName(@Param("name") String name);

}
