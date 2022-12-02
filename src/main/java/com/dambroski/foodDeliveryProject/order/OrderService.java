package com.dambroski.foodDeliveryProject.order;

import java.util.List;

public interface OrderService {

	List<Order> getAll();

	Order post(Order order,Long userId) throws Exception;

	void deleteById(Long orderId);


}
