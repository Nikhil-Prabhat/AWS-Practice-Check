package com.order.service;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.order.client.MenuitemClient;
import com.order.dojo.Menuitem;
import com.order.entity.Orderitem;
import com.order.repository.OrderItemRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemServiceTest {

	@InjectMocks
	OrderItemServiceImpl service;

	@Mock
	OrderItemRepository orderitemRepository;

	@Mock
	MenuitemClient menuitemClient;

	@Mock
	Menuitem menu;

	@Mock
	Orderitem orderitem;

	@Before
	public void before() {
		menu = new Menuitem(1, "a", 250.00, "adad", true);
		orderitem = new Orderitem();
		orderitem.setMenuid(1);
		orderitem.setStatus(true);
		orderitem.setDateoforder(new Date());
		orderitem.setOrderid(1);
		orderitem.setPrice(200.0);
	}

	@Test
	public void makeOrderTest() {
		when(menuitemClient.getMenuItemById("token", 123)).thenReturn(menu);
		when(orderitemRepository.save(orderitem)).thenReturn(orderitem);
		service.makeOrder(123, "token");
	}
	
	@Test
	public void makeOrderTeststatus()  {
		menu.setActive(false);
		orderitem.setStatus(false);
		when(menuitemClient.getMenuItemById("token", 123)).thenReturn(menu);
		when(orderitemRepository.save(orderitem)).thenReturn(orderitem);
		service.makeOrder(123, "token");
	}


	@Test(expected = NullPointerException.class)
	public void insertFailed() {
		when(menuitemClient.getMenuItemById("token",123)).thenReturn(null);
		service.makeOrder(123, "token"); 
	}

	/*
	 * @Test public void insertSucessstatus() throws MenuItemNotFoundException {
	 * Menuitem menu = new Menuitem(1,"a",250.00,"adad",false);
	 * when(menuitemClient.getMenuItemById("token",1)).thenReturn(new
	 * ResponseEntity<Menuitem>(menu, HttpStatus.OK)); String makeOrder =
	 * service.makeOrder(1, "token"); assertEquals(makeOrder, null); }
	 * 
	 * 
	 * @Test public void insertFailed() throws MenuItemNotFoundException {
	 * assertThrows(InternalServerError.class, () -> service.makeOrder(10, "token"),
	 * "MenuItem not Present with this Id.");
	 * 
	 * }
	 */
}
