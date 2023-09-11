package com.bookstore.bookstoreapplication.service;

import java.util.List;

import com.bookstore.bookstoreapplication.dto.CartDTO;
import com.bookstore.bookstoreapplication.entity.CartModel;

public interface ICartService {

	// Add data
	CartModel insert(CartDTO modeldto);

	// Get data
	List<CartModel> getAll();

	// Get data by Id
	CartModel getById(int id);

	// Delete data by Id
	String deleteById(int id);

	// Update data by Id
	CartModel updateById(int id, CartDTO modeldto);

	// Update book quantity
	CartModel updateQuantityById(int id, String quantity);
	
}