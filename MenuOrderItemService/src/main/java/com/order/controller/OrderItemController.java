package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.client.AuthClient;
import com.order.dojo.AuthResponse;
import com.order.entity.Orderitem;
import com.order.service.OrderItemService;

@RestController
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;
	@Autowired
	AuthClient authclient;

	@RequestMapping(path = "/order/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> insertNewOrderItem(@RequestHeader(name = "Authorization") String token,
			@PathVariable int id) {
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {

			Orderitem makeOrder = orderItemService.makeOrder(id, token);
			return new ResponseEntity<Orderitem>(makeOrder, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("You are not LoggedIn", HttpStatus.FORBIDDEN);
		}
	}

}
