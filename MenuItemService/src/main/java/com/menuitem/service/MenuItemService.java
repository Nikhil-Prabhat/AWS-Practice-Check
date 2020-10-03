package com.menuitem.service;

import java.util.List;

import com.menuitem.entity.Menuitem;
import com.menuitem.exception.MenuItemNotFoundException;

public interface MenuItemService {
	public List<Menuitem> getallMenuItem();

	public Menuitem getMenuItemById(int id) throws MenuItemNotFoundException;

}
