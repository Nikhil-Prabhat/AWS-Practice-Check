package com.order.service;

import com.order.entity.Orderitem;

public interface OrderItemService {

	public Orderitem makeOrder(int menuitemid,String token);
}
