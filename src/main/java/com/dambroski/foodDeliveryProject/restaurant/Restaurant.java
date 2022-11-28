package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.dambroski.foodDeliveryProject.User.User;
import com.dambroski.foodDeliveryProject.food.Food;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
	
	@Id
	@GeneratedValue(generator = "restaurant_id",strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "restaurant_id",sequenceName = "restaurant_id",allocationSize = 1)
	private Long id;
	
	private String name;
	
	private String description;
	
	private Type type;
	
	@OneToOne
	@JoinColumn(name = "user_id",referencedColumnName = "userId")
	private User user;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "food_id",referencedColumnName = "foodId")
	private List<Food> foods;

}
