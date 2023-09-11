package com.bookstore.bookstoreapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoreapplication.dto.OrderDTO;
import com.bookstore.bookstoreapplication.entity.OrderModel;
import com.bookstore.bookstoreapplication.entity.UserModel;
import com.bookstore.bookstoreapplication.exception.BookStoreException;
import com.bookstore.bookstoreapplication.repository.OrderRepository;
import com.bookstore.bookstoreapplication.repository.UserRepository;
import com.bookstore.bookstoreapplication.util.BookStoreEmailSenderService;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	OrderRepository repository;
	
	@Autowired
	BookStoreEmailSenderService emailsender;
	
	@Autowired
	UserRepository userRepository;

	// Add data
	@Override
	public OrderModel insert(OrderDTO modeldto) {
		OrderModel order = new OrderModel(modeldto);
		repository.save(order);
		Optional<UserModel> user = userRepository.findById(order.getUserID());
		emailsender.sendEmail(user.get().getEmail(), "Email for BookStore", "Hello "+
				user.get().getFirstName()+",\n\n"+"Order added\n"+"Order Id: "+
				order.getOrderID()+"\nTotal Price: "+order.getTotalPrice()+"\nQuantity: "+
				order.getQuantity()+"\nAddress: "+order.getAddress()+"\nUser Id: "+order.getUserID()+
				"\nBook Id: "+order.getBookID());
		return order;
	}

	// Get data
	@Override
	public List<OrderModel> getAll() {
		return repository.findAll();
	}

	// Get data by Id
	@Override
	public OrderModel getById(int id) {
		Optional<OrderModel> order = repository.findById(id);
		if (order.isPresent()) {
			return order.get();
		} 
		else throw new BookStoreException("Order Not Found");
	}

	// Delete data by Id
	@Override
	public String deleteById(int id) {
		Optional<OrderModel> order = repository.findById(id);
		if (order.isPresent()) {
			Optional<UserModel> user = userRepository.findById(order.get().getUserID());
			emailsender.sendEmail(user.get().getEmail(), "Email for BookStore", "Hello "+
					user.get().getFirstName()+",\n\n"+"Order deleted\n"+"Order Id: "+
					order.get().getOrderID()+"\nBook Id: "+order.get().getBookID()+
					"\nQuantity: "+order.get().getQuantity());
			repository.deleteById(id);
			return "Deleted successfully";
		} 
		else throw new BookStoreException("Order Not Found");
	}

	// Update data by Id
	@Override
	public OrderModel updateById(int id, OrderDTO modeldto) {
		Optional<OrderModel> order = repository.findById(id);
		if (order.isPresent()) {
			order = Optional.of(new OrderModel(order.get().getOrderID(), modeldto));
			repository.save(order.get());
			Optional<UserModel> user = userRepository.findById(order.get().getUserID());
			emailsender.sendEmail(user.get().getEmail(), "Email for BookStore", "Hello "+
					user.get().getFirstName()+",\n\n"+"Order updated\n"+"Order Id: "+
					order.get().getOrderID()+"\nTotal Price: "+order.get().getTotalPrice()+"\nQuantity: "+
					order.get().getQuantity()+"\nAddress: "+order.get().getAddress()+"\nUser Id: "+
					order.get().getUserID()+"\nBook Id: "+order.get().getBookID());
			return order.get();
		} 
		else throw new BookStoreException("Order Not Found");
	}

	// Cancel order
	@Override
	public String cancelorderById(int id) {
		Optional<OrderModel> order = repository.findById(id);
		if (order.isPresent()) {
			order.get().setCancel(true);
			repository.save(order.get());
			Optional<UserModel> user = userRepository.findById(order.get().getUserID());
			emailsender.sendEmail(user.get().getEmail(), "Email for BookStore", "Hello "+
					user.get().getFirstName()+",\n\n"+"Order cancelled\n"+"Order Id: "+
					order.get().getOrderID()+"\nTotal Price: "+order.get().getTotalPrice()+"\nQuantity: "+
					order.get().getQuantity()+"\nAddress: "+order.get().getAddress()+"\nUser Id: "+
					order.get().getUserID()+"\nBook Id: "+order.get().getBookID());
			return "Order cancelled";
		} 
		else throw new BookStoreException("Order Not Found");
	}

}