package com.cognizant;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.controller.OrderController;
import com.cognizant.entity.Orders;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.MenuItem;
import com.cognizant.service.OrderServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceApplication.class)
class OrderServiceApplicationTests {

	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@Autowired
	OrderController orderController;

	@Test
	void contextLoads() {
	}

	@Test
	public void main() {
		OrderServiceApplication.main(new String[] {});
	}

	@Test
	public void testMakeOrderService() {
		String actual = orderServiceImpl.makeOrder(1);
		String expected = "Your Order is placed";

		assertEquals(actual, expected);
	}
	
	@Nested
	class testEntity
	{
		Orders orders = new Orders();
		
		@Test
		public void testMenuId()
		{
			orders.setMenuid(1);
			assertEquals(orders.getMenuid(),1);
		}
		
		@Test
		public void testOrderId()
		{
			orders.setOrderid(1);;
			assertEquals(orders.getOrderid(),1);
		}
		
		@Test
		public void testPrice()
		{
			orders.setPrice(200);;
			assertEquals(orders.getPrice(),200,0.0f);
		}
		
		@Test
		public void testDateOfOrder()
		{
			orders.setDateOfOrder(new Date());
			assertEquals(orders.getDateOfOrder(),new Date());
		}
		
		@Test
		public void testStatus()
		{
			orders.setStatus(true);;
			assertEquals(orders.isStatus(),true);
		}
		
		@Test
		public void testToString()
		{
			String s = orders.toString();
			assertEquals(orders.toString(),s);
		}
		
		
	}
	
	@Nested
	class testModel
	{
		AuthResponse authResponse = new AuthResponse();
		MenuItem menuItem = new MenuItem();
		
		@Test
		public void testName()
		{
			authResponse.setName("Admin");
			assertEquals(authResponse.getName(),"Admin");
		}
		
		@Test
		public void testConstructor()
		{
			AuthResponse auth = new AuthResponse("admin","admin",true);
			assertEquals(true, auth.isValid());
		}
		
		@Test
		public void testUid()
		{
			authResponse.setUid("Admin");
			assertEquals(authResponse.getUid(), "Admin");
		}
		
		@Test
		public void testValid()
		{
			authResponse.setValid(true);
			assertEquals(authResponse.isValid(), true);
		}
		
		@Test
		public void testToString()
		{
			String s = authResponse.toString();
			assertEquals(authResponse.toString(), s);
		}
		
		
		@Test
		public void testMenuConstructor()
		{
			MenuItem menu = new MenuItem(1,"menu",200,"menu",true);
			assertEquals(menu.getMenuid(),1);
			
		}
		
		
		@Test
		public void testMenuId()
		{
			menuItem.setMenuid(1);
			assertEquals(menuItem.getMenuid(), 1);
		}
		
		@Test
		public void testMenuName()
		{
			menuItem.setMenuname("menu");;
			assertEquals(menuItem.getMenuname(), "menu");
		}
		
		@Test
		public void testMenuPrice()
		{
			menuItem.setPrice(200);;
			assertEquals(menuItem.getPrice(), 200,0.0f);
		}
		
		@Test
		public void testMenuDesc()
		{
			menuItem.setDesc("Desc");
			assertEquals(menuItem.getDesc(), "Desc");
		}
		
		@Test
		public void testMenuActive()
		{
			menuItem.setActive(true);
			assertEquals(menuItem.isActive(), true);
		}
		
		@Test
		public void testMenuToString()
		{
			String s = menuItem.toString();
			assertEquals(menuItem.toString(), s);
		}
		
		
		
		
		
	}
	
	

}
