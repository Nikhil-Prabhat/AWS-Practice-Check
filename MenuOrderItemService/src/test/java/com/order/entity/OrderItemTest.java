
package com.order.entity;


import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class OrderItemTest {

	Orderitem order = new Orderitem();

	@Test
	public void testMenuId() {
		order.setMenuid(15);
		assertEquals(order.getMenuid(), 15);
	}

	@Test
	public void testOrderId() {
		order.setOrderid(15);
		assertEquals(order.getOrderid(), 15);
	}

	@Test
	public void testPrice() {
		order.setPrice(400.0);
		assertEquals(order.getPrice(), order.getPrice());
	}

	@Test
	public void testDateOfOrder() throws ParseException {
		Date dateoforder = new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2020");
		order.setDateoforder(dateoforder);
		assertEquals(order.getDateoforder(), dateoforder);
	}

	@Test
	public void testStatus() {
		order.setStatus(true);
		assertEquals(order.isStatus(), true);
	}

	@Test
	public void testtoString() {
		String s = order.toString();
		assertEquals(order.toString(), s);
	}
}
