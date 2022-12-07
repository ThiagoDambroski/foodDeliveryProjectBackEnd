package com.dambroski.foodDeliveryProject.delivery;

import java.util.List;

public interface DeliveryService {

	List<Delivery> getAll();

	List<Delivery> getByRegionDelivery(Long boyId);

}
