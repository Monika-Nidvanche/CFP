package com.bookstore.bookstoreapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstoreapplication.dto.OrderDTO;
import com.bookstore.bookstoreapplication.dto.responseDTO;
import com.bookstore.bookstoreapplication.entity.OrderModel;
import com.bookstore.bookstoreapplication.service.IOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	IOrderService service;
	
	// Add data
	@PostMapping("/insert")
	public ResponseEntity<responseDTO> insert(@Valid @RequestBody OrderDTO modeldto) {

		OrderModel book = service.insert(modeldto);
		responseDTO response = new responseDTO("Book added successfully", book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.CREATED);

	}
	
	// Get data
	@GetMapping("/getAll")
	public ResponseEntity<responseDTO> getAll() {

		List<OrderModel> order = service.getAll();
		responseDTO response = new responseDTO("List of Order", order);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}
	
	// Get data by Id
	@GetMapping("/getById/{Id}")
	public ResponseEntity<responseDTO> getById(@PathVariable int Id) {

		OrderModel order = service.getById(Id);
		responseDTO response = new responseDTO("Order for Id " + Id, order);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}
	
	// Delete data by Id
	@DeleteMapping("/deleteById/{Id}")
	public ResponseEntity<responseDTO> deleteById(@PathVariable int Id) {

		String message = service.deleteById(Id);
		responseDTO response = new responseDTO("Deleted", message);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}
	
	// Update data by Id
	@PutMapping("/updateById/{Id}")
	public ResponseEntity<responseDTO> updateById(@PathVariable int Id, @Valid @RequestBody OrderDTO modeldto) {

		OrderModel order = service.updateById(Id, modeldto);
		responseDTO response = new responseDTO("Updated successfully", order);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}
	
	// Cancel order
	@PutMapping("/cancelOrder/{Id}")
	public ResponseEntity<responseDTO> cancelorderById(@PathVariable int Id) {

		String message = service.cancelorderById(Id);
		responseDTO response = new responseDTO("Order cancelled", message);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}

}
