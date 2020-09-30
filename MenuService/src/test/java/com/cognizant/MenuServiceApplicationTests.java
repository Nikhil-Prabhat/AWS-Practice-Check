package com.cognizant;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.Controller.MenuItemController;
import com.cognizant.entity.MenuItem;
import com.cognizant.service.MenuItemServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MenuServiceApplication.class)
class MenuServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MenuItemServiceImpl menuItemService;

	@Autowired
	MenuItemController menuItemController;

	@Test
	public void main() {
		MenuServiceApplication.main(new String[] {});
	}

	@Test
	public void testServiceGetAll() {
		String actual = menuItemService.getAll().toString();
		String expected = "[MenuItem(menuid=1, menuname=Apple, price=200.0, desc=Fruits, active=true), MenuItem(menuid=2, menuname=Potato, price=300.0, desc=Vegetables, active=true)]";

		assertEquals(actual, expected);

	}

	@Test
	public void testServiceGetById() {
		String actual = menuItemService.getById(1).toString();
		String expected = "MenuItem(menuid=1, menuname=Apple, price=200.0, desc=Fruits, active=true)";
		assertEquals(actual, expected);
	}

	@Test
	public void testControllerGetAll() {
		String actual = menuItemController.getAll().getBody().toString();
		String expected = "[MenuItem(menuid=1, menuname=Apple, price=200.0, desc=Fruits, active=true), MenuItem(menuid=2, menuname=Potato, price=300.0, desc=Vegetables, active=true)]";

		assertEquals(actual, expected);
	}

	@Test
	public void testControllerGetById() {
		String actual = menuItemController.getById(1).getBody().toString();
		String expected = "MenuItem(menuid=1, menuname=Apple, price=200.0, desc=Fruits, active=true)";
		assertEquals(actual, expected);
	}

	@Test
	public void testControllerGetByIdNotFound() {
		String actual = menuItemController.getById(3).getBody().toString();
		String expected = "MenuItem Not Found";
		assertEquals(actual, expected);
	}

	@Nested
	class testModel {

		MenuItem menuItem = new MenuItem();

		@Test
		public void testMenuConstructor() {
			MenuItem menu = new MenuItem(1, "menu", 200, "menu", true);
			assertEquals(menu.getMenuid(), 1);

		}

		@Test
		public void testMenuId() {
			menuItem.setMenuid(1);
			assertEquals(menuItem.getMenuid(), 1);
		}

		@Test
		public void testMenuName() {
			menuItem.setMenuname("menu");
			;
			assertEquals(menuItem.getMenuname(), "menu");
		}

		@Test
		public void testMenuPrice() {
			menuItem.setPrice(200);
			;
			assertEquals(menuItem.getPrice(), 200, 0.0f);
		}

		@Test
		public void testMenuDesc() {
			menuItem.setDesc("Desc");
			assertEquals(menuItem.getDesc(), "Desc");
		}

		@Test
		public void testMenuActive() {
			menuItem.setActive(true);
			assertEquals(menuItem.isActive(), true);
		}

		@Test
		public void testMenuToString() {
			String s = menuItem.toString();
			assertEquals(menuItem.toString(), s);
		}

	}

}
