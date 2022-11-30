package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Columns;

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
	@GeneratedValue(generator = "restaurant_id",strategy = GenerationType.AUTO)
	private Long restaurantId;
	
	private String name;
	
	private String description;
	
	private Type type;
	
	@OneToOne
	private User user;
	
	
	@OneToMany(mappedBy = "restaurant")
	private List<Food> foods;

}
