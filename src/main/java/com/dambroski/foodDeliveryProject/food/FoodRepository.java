package com.dambroski.foodDeliveryProject.food;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FoodRepository extends JpaRepository<Food, Long>{
	
	@Query("select f from Food f where f.name like '%'||:name||'%' ")
	List<Food> getFoodByName(@Param("name") String name);
	
	//@Query("select f from Food f where :category member of f.category")
	List<Food> findByCategory(@Param("category") Category category);

}
