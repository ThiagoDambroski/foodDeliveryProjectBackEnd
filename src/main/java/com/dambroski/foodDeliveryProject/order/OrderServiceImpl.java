package com.dambroski.foodDeliveryProject.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.foodDeliveryProject.User.UserRepository;
import com.dambroski.foodDeliveryProject.error.NotEnoughFoodException;
import com.dambroski.foodDeliveryProject.food.Food;
import com.dambroski.foodDeliveryProject.food.FoodRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository repository;
	
	@Autowired
	FoodRepository foodRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Order> getAll() {
		return repository.findAll();
	}

	@Override
	public Order post(Order order,Long userId) {
		List<OrderFood> list = order.getFoods();
		double sum = 0;
		for (OrderFood orderFood : list) {
			Food food = foodRepository.findById(orderFood.getFoodId()).get();
			if(food.getStock() >= orderFood.getQuantity()) {
				food.setStock(food.getStock() - orderFood.getQuantity());
				foodRepository.save(food);
				sum += orderFood.getQuantity() * food.getPrice();
			}else {
				throw new NotEnoughFoodException(String.format("The %s dosent have %i itens in stock,only %i"
						, food.getName(),orderFood.getQuantity(),food.getStock()));
			}	
		}
		order.setUser(userRepository.findById(userId).get());
		order.setTotalValue(sum);
		order.setStatus(OrderStatus.IN_PROCESS);
		
		return repository.save(order);
	}

}
