package com.dambroski.foodDeliveryProject.order;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.dambroski.foodDeliveryProject.User.User;
import com.dambroski.foodDeliveryProject.orderFood.OrderFood;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
	
	
	@Id
	@GeneratedValue(generator = "order_id",strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "userId",updatable = true)
	private User user;
	
	@JsonIgnore
	@ElementCollection(targetClass = Long.class)
	private List<Long> foodsId;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "order_id",referencedColumnName = "orderId"),inverseJoinColumns = 
	@JoinColumn(name = "order_food_id",referencedColumnName = "orderFoodId"))
	private List<OrderFood> foods;
	
	private OrderStatus status;
	
	private double totalValue;

}
