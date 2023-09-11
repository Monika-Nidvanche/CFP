package com.bookstore.bookstoreapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
	
	private int totalPrice;
	private int quantity;
	private String address;
	private int userID;
	private int bookID;
	private boolean cancel;

}