package com.bookstore.bookstoreapplication.entity;

import java.time.LocalDate;

import com.bookstore.bookstoreapplication.dto.OrderDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderID;
	
	private LocalDate date = LocalDate.now();
	private int totalPrice;
	private int quantity;
	private String address;
	private int userID;
	private int bookID;
	private boolean cancel;
	
	public OrderModel(OrderDTO modeldto) {
		this.totalPrice = modeldto.getTotalPrice();
		this.quantity = modeldto.getQuantity();
		this.address = modeldto.getAddress();
		this.userID = modeldto.getUserID();
		this.bookID = modeldto.getBookID();
		this.cancel = modeldto.isCancel();
	}

	public OrderModel(int orderId, OrderDTO modeldto) {
		this.orderID = orderId;
		this.totalPrice = modeldto.getTotalPrice();
		this.quantity = modeldto.getQuantity();
		this.address = modeldto.getAddress();
		this.userID = modeldto.getUserID();
		this.bookID = modeldto.getBookID();
		this.cancel = modeldto.isCancel();
	}

}
