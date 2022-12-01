package com.dambroski.foodDeliveryProject.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.foodDeliveryProject.User.UserRepository;
import com.dambroski.foodDeliveryProject.error.NotEnoughFoodException;
import com.dambroski.foodDeliveryProject.food.Food;
import com.dambroski.foodDeliveryProject.food.FoodRepository;
import com.dambroski.foodDeliveryProject.orderFood.OrderFood;
import com.dambroski.foodDeliveryProject.orderFood.OrderFoodRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository repository;
	
	@Autowired
	FoodRepository foodRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderFoodRepository orderFoodRepository;
	

	@Override
	public List<Order> getAll() {
		return repository.findAll();
	}

	@Override
	public Order post(Order order,Long userId) throws Exception {
		List<Long> listIds = order.getFoodsId();
		List<OrderFood> list = new ArrayList<>();
		if(listIds == null) {
			throw new Exception("getFoodsIds is empty");
		}
		if(order.getFoods() != null) {
			list = order.getFoods();
		}
		
		double sum = 0;
		
		for (Long id : listIds) {
			
			list.add(orderFoodRepository.findById(id).get());
			
		}	
		
		
		for (OrderFood orderFood : list) {
			Food food = orderFood.getFood();
			if(food.getStock() >= orderFood.getQuantity()) {
				food.setStock(food.getStock() - orderFood.getQuantity());
				foodRepository.save(food);
				sum += orderFood.getQuantity() * food.getPrice();
			}else {
				throw new NotEnoughFoodException(String.format("The %s dosent have %i itens in stock,only %i"
						, food.getName(),orderFood.getQuantity(),food.getStock()));
			}	
		}
		order.setFoods(list);
		order.setUser(userRepository.findById(userId).get());
		order.setTotalValue(sum);
		order.setStatus(OrderStatus.IN_PROCESS);
		
		return repository.save(order);
	}

}
