package com.menuitem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "MenuItem not Present")
public class MenuItemNotFoundException extends Exception {

	public MenuItemNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
