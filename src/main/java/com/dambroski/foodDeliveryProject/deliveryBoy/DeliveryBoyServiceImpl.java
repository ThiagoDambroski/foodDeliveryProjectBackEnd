package com.dambroski.foodDeliveryProject.deliveryBoy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.dambroski.foodDeliveryProject.User.User;
import com.dambroski.foodDeliveryProject.User.UserRepository;
import com.dambroski.foodDeliveryProject.delivery.Delivery;
import com.dambroski.foodDeliveryProject.delivery.DeliveryService;

@Service
public class DeliveryBoyServiceImpl implements DeliveryBoyService {
	
	@Autowired
	DeliveryBoyRepository repository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<DeliveryBoy> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public DeliveryBoy postDelivery(DeliveryBoy deliveryBoy,Long userId) {
		User user = userRepository.findById(userId).get();
		if(user.getRole().equals("delivery")) {
			deliveryBoy.setUser(user);
		}else {
			throw new BadCredentialsException("user is not a deliveryBoy");
		}
		return repository.save(deliveryBoy);
	}



}
