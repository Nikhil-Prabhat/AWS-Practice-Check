package com.order.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.client.MenuitemClient;
import com.order.dojo.Menuitem;
import com.order.entity.Orderitem;
import com.order.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	MenuitemClient menuitemClient;

	@Transactional
	public Orderitem makeOrder(int menuitem,String token)  {
		Orderitem orderitem = new Orderitem();
			Menuitem menuItemById = menuitemClient.getMenuItemById(token,menuitem);
			orderitem.setMenuid(menuitem);
			orderitem.setPrice(menuItemById.getPrice());
			Date dateoforder = new Date();
			orderitem.setDateoforder(dateoforder);
			if (menuItemById.isActive()) {
				orderitem.setStatus(true);
			} else {
				orderitem.setStatus(false);
			}
			orderItemRepository.save(orderitem);
			return orderitem;
		}
	}
