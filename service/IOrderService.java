package com.bookstore.bookstoreapplication.service;

import java.util.List;

import com.bookstore.bookstoreapplication.dto.OrderDTO;
import com.bookstore.bookstoreapplication.entity.OrderModel;

public interface IOrderService {

	// Add data
	OrderModel insert(OrderDTO modeldto);

	// Get data
	List<OrderModel> getAll();

	// Get data by Id
	OrderModel getById(int id);

	// Delete data by Id
	String deleteById(int id);

	// Update data by Id
	OrderModel updateById(int id, OrderDTO modeldto);

	// Cancel order
	String cancelorderById(int id);

}