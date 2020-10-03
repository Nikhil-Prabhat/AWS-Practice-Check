package com.order.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "orderitem")
public class Orderitem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	private int menuid;
	private Double price;
	private Date dateoforder;
	private boolean status;
}
