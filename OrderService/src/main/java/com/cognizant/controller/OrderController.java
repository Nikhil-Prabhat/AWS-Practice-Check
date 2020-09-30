package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.service.OrderServiceImpl;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderServiceImpl orderServiceImpl;

	@GetMapping("{id}")
	public ResponseEntity<?> makeOrder(@RequestHeader(name="auth")String token,@PathVariable("id") int id) {
		String makeOrder = orderServiceImpl.makeOrder(id);
		return new ResponseEntity<>(makeOrder, HttpStatus.OK);
	}

}
