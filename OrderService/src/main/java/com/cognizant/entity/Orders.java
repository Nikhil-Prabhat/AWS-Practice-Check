package com.cognizant.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Orders {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	private int menuid;
	private double price;
	private Date dateOfOrder;
	private boolean status;

	public Orders(int menuid, double price, Date dateOfOrder, boolean status) {
		super();
		this.menuid = menuid;
		this.price = price;
		this.dateOfOrder = dateOfOrder;
		this.status = status;
	}

}
