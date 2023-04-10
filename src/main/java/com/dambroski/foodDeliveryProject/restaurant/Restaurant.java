package com.dambroski.foodDeliveryProject.restaurant;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.dambroski.foodDeliveryProject.Address.Address;
import com.dambroski.foodDeliveryProject.User.User;
import com.dambroski.foodDeliveryProject.food.Food;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
	
	@Id
	@GeneratedValue(generator = "restaurant_id",strategy = GenerationType.IDENTITY)
	private Long restaurantId;
	
	private String name;

	private String description;
	
	@JsonIgnoreProperties({"restaurant"})
	@OneToMany(mappedBy = "restaurant")
	private List<Food> itens;
	
	@JsonIgnoreProperties({"type","typeId"})
	@OneToOne
	private Address address;
	
	@JsonIncludeProperties({"userId","name"})
	@OneToOne(fetch = FetchType.EAGER)
	private User restaurantOwner;
	
}
