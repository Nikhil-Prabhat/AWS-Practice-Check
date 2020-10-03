package com.order.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.order.client.AuthClient;
import com.order.dojo.AuthResponse;
import com.order.entity.Orderitem;
import com.order.repository.OrderItemRepository;
import com.order.service.OrderItemService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemControllerTest {

	@InjectMocks
	OrderItemController orderItemController;

	@Mock
	AuthClient authclient;

	AuthResponse authResponse;

	@Mock
	OrderItemService orderItemService;

	@Mock
	OrderItemRepository orderItemRepository;

	@Mock
	Orderitem orderitem;

	@Test
	public void createOrder() {
		when(authclient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		when(orderItemService.makeOrder(1, "token")).thenReturn(orderitem);
		ResponseEntity<?> insertNewOrderItem = orderItemController.insertNewOrderItem("token", 1);
		assertNotNull(insertNewOrderItem);
	}

	@Test
	public void createOrderFailed() {
		when(authclient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", false));
		when(orderItemService.makeOrder(1, "token")).thenReturn(null);
		ResponseEntity<?> insertNewOrderItem = orderItemController.insertNewOrderItem("token", 1);
		assertEquals(403, insertNewOrderItem.getStatusCodeValue());
	}
}
