package com.order.dojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Menuitem {
	private int menuid;
	private String menuname;
	private Double price;
	private String category;
	private boolean active;
}
