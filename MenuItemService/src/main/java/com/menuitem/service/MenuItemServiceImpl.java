package com.menuitem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuitem.entity.Menuitem;
import com.menuitem.exception.MenuItemNotFoundException;
import com.menuitem.repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	MenuItemRepository menuItemRepository;

	@Transactional
	public List<Menuitem> getallMenuItem() {
		List<Menuitem> findAll = menuItemRepository.findAll();
		return findAll;
	}

	@Transactional
	public Menuitem getMenuItemById(int id) throws MenuItemNotFoundException {
		if (menuItemRepository.findById(id).isPresent()) {
			Menuitem menuitem = menuItemRepository.findById(id).get();
			return menuitem;
		} else {
			throw new MenuItemNotFoundException("MenuItem not Present with this Id.");
		}
	}

}
