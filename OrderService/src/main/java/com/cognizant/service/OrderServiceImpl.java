package com.cognizant.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.client.OrderClient;
import com.cognizant.entity.Orders;
import com.cognizant.model.MenuItem;
import com.cognizant.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderClient orderClient;
	
	
	@Override
	public String makeOrder(int id) {
		
		MenuItem menuItem = orderClient.getById(id);
		int menuid = menuItem.getMenuid();
		double price = menuItem.getPrice();
		boolean active = menuItem.isActive();
		
		Orders order = new Orders(menuid,price,new Date(),active);
		orderRepository.save(order);
		
		return "Your Order is placed";
		
		
	}

}
