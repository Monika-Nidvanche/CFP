package com.bookstore.bookstoreapplication.entity;

import com.bookstore.bookstoreapplication.dto.CartDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CartModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartID;
	
	private int userID;
	private int bookID;
	private String quantity;
	
	public CartModel(CartDTO modeldto) {
		this.userID = modeldto.getUserID();
		this.bookID = modeldto.getBookID();
		this.quantity = modeldto.getQuantity();
	}

	public CartModel(int cartId, CartDTO modeldto) {
		this.cartID = cartId;
		this.userID = modeldto.getUserID();
		this.bookID = modeldto.getBookID();
		this.quantity = modeldto.getQuantity();
	}

}