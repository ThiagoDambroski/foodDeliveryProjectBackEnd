package com.dambroski.foodDeliveryProject.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

		List<Order> findAllByUser_UserId(Long userId);
}
