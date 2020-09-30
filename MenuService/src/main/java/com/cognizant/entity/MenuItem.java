package com.cognizant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MenuItem {
	
	@Id
	@NotNull
	private int menuid;
	private String menuname;
	private double price;
	private String desc;
	private boolean active;
	
	

}
