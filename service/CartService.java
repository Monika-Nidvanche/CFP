package com.bookstore.bookstoreapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoreapplication.dto.CartDTO;
import com.bookstore.bookstoreapplication.entity.CartModel;
import com.bookstore.bookstoreapplication.exception.BookStoreException;
import com.bookstore.bookstoreapplication.repository.CartRepository;

@Service
public class CartService implements ICartService {
	
	@Autowired
	CartRepository repository;

	// Add data
	@Override
	public CartModel insert(CartDTO modeldto) {
		CartModel book = new CartModel(modeldto);
		repository.save(book);
		return book;
	}

	// Get data
	@Override
	public List<CartModel> getAll() {
		return repository.findAll();
	}

	// Get data by Id
	@Override
	public CartModel getById(int id) {
		Optional<CartModel> cart = repository.findById(id);
		if (cart.isPresent()) {
			return cart.get();
		} 
		else throw new BookStoreException("Cart Not Found");
	}

	// Delete data by Id
	@Override
	public String deleteById(int id) {
		Optional<CartModel> cart = repository.findById(id);
		if (cart.isPresent()) {
			repository.deleteById(id);
			return "Deleted successfully";
		} 
		else throw new BookStoreException("Cart Not Found");
	}

	// Update data by Id
	@Override
	public CartModel updateById(int id, CartDTO modeldto) {
		Optional<CartModel> cart = repository.findById(id);
		if (cart.isPresent()) {
			cart = Optional.of(new CartModel(cart.get().getCartID(), modeldto));
			repository.save(cart.get());
			return cart.get();
		} 
		else throw new BookStoreException("Cart Not Found");
	}

	// Update book quantity
	@Override
	public CartModel updateQuantityById(int id, String quantity) {
		Optional<CartModel> cart = repository.findById(id);
		if (cart.isPresent()) {
			cart.get().setQuantity(quantity);
			repository.save(cart.get());
			return cart.get();
		} 
		else throw new BookStoreException("Cart Not Found");
	}

}