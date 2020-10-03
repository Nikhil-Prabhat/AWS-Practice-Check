package com.menuitem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "menuitem")
public class Menuitem {
	@Id
	private int menuid;
	private String menuname;
	private Double price;
	private String category;
	private boolean active;
}
