package com.menuitem.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.menuitem.client.AuthClient;
import com.menuitem.client.AuthResponse;
import com.menuitem.entity.Menuitem;
import com.menuitem.exception.MenuItemNotFoundException;
import com.menuitem.repository.MenuItemRepository;
import com.menuitem.service.MenuItemService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuItemControllerTest {

	@Mock
	MenuItemService service;

	@InjectMocks
	MenuItemController menuItemController;

	@Mock
	AuthClient authclient;

	@Mock
	MenuItemRepository repo;

	@Mock
	Menuitem item;

	AuthResponse authResponse;
	// List<Menuitem> menuItemList;

	@Before
	public void setup() {
		item.setActive(true);
		item.setCategory("ad");
		item.setMenuid(6);
		item.setMenuname("ada");
		item.setPrice(400.00);
	}

	@Test
	public void getAllMenuItem() {
		when(authclient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		// when(service.getallMenuItem()).thenReturn(menuItemList);
		ResponseEntity<?> allMenuItem = menuItemController.getAllMenuItem("token");
		assertNotNull(allMenuItem);
	}

	@Test
	public void getAllMenuItemFailed() {
		when(authclient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", false));
		// when(service.getallMenuItem()).thenReturn(null);
		ResponseEntity<?> allMenuItem = menuItemController.getAllMenuItem("token");
		assertEquals(403, allMenuItem.getStatusCodeValue());
	}

	@Test
	public void getByIdTest() throws MenuItemNotFoundException {
		when(authclient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		when(service.getMenuItemById(6)).thenReturn(item);
		ResponseEntity<?> menuitem = menuItemController.getMenuItemById("token", 6);
		assertEquals(200, menuitem.getStatusCodeValue());
		assertNotNull(menuitem);
	}

	@Test
	public void getByIdNotFoundTest() throws MenuItemNotFoundException {
		when(authclient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		when(service.getMenuItemById(123)).thenThrow(MenuItemNotFoundException.class);
		ResponseEntity<?> menuitem = menuItemController.getMenuItemById("token", 123);
		assertEquals(404, menuitem.getStatusCodeValue());
		assertNotNull(menuitem);

	}

	@Test
	public void getByIdFail() throws MenuItemNotFoundException {
		when(authclient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", false));
		// when(service.getMenuItemById(6)).thenReturn(new Menuitem(6, "ADA", 250.00,
		// "abc", true));
		ResponseEntity<?> menuitem = menuItemController.getMenuItemById("token", 6);
		assertEquals(403, menuitem.getStatusCodeValue());
	}

}
