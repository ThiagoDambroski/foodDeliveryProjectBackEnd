package com.dambroski.foodDeliveryProject.delivery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.dambroski.foodDeliveryProject.Address.Address;
import com.dambroski.foodDeliveryProject.deliveryBoy.DeliveryBoy;
import com.dambroski.foodDeliveryProject.order.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Delivery {
	
	@Id
	@GeneratedValue(generator = "delivery_id",strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Order order;
	
	private DeliveryStatus status;
	
	@OneToOne
	private Address selectAddress;
	
	@ManyToOne
	private DeliveryBoy boy;
	
	
	
	
}
