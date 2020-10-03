
package com.menuitem.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.menuitem.entity.Menuitem;

public class MenuItemTest {

	Menuitem menu = new Menuitem();

	@Test
	public void testMenuId() {
		menu.setMenuid(15);
		assertEquals(menu.getMenuid(), 15);
	}

	@Test
	public void testMenuName() {
		menu.setMenuname("A");
		assertEquals(menu.getMenuname(), "A");
	}

	@Test
	public void testPrice() {
		menu.setPrice(400.0);
		assertEquals(menu.getPrice(), menu.getPrice());
	}

	@Test
	public void testCategory() {
		menu.setCategory("category");
		assertEquals(menu.getCategory(), "category");
	}

	@Test
	public void testActive() {
		menu.setActive(true);
		assertEquals(menu.isActive(), true);
	}

	@Test
	public void testtoString() {
		String s = menu.toString();
		assertEquals(menu.toString(), s);
	}
}
