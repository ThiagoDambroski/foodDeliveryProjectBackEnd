package com.dambroski.foodDeliveryProject.deliveryBoy;

import java.util.List;

public interface DeliveryBoyService {

	List<DeliveryBoy> getAll();

	DeliveryBoy postDelivery(DeliveryBoy deliveryBoy, Long userId);
	
}
