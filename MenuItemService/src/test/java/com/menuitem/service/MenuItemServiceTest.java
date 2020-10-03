package com.menuitem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.menuitem.entity.Menuitem;
import com.menuitem.exception.MenuItemNotFoundException;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuItemServiceTest {

	@Autowired
	MenuItemService service;

	@Test
	public void getAllMenuItem() {
		List<Menuitem> getallMenuItem = service.getallMenuItem();
		assertEquals(getallMenuItem.get(0).getMenuid(), 1);
	}

	@Test
	public void getByIdTest() throws MenuItemNotFoundException {
		Menuitem menuItemById = service.getMenuItemById(1);
		assertEquals(menuItemById.getMenuid(), 1);
	}

	@Test
	public void getByIdFail() throws MenuItemNotFoundException {
		assertThrows(MenuItemNotFoundException.class, () -> service.getMenuItemById(20),
				"MenuItem not Present with this Id.");
	}

}
