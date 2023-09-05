package com.bookstore.bookstoreapplication.entity;

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

}
