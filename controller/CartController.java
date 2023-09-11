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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstoreapplication.dto.CartDTO;
import com.bookstore.bookstoreapplication.dto.responseDTO;
import com.bookstore.bookstoreapplication.entity.CartModel;
import com.bookstore.bookstoreapplication.service.ICartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	ICartService service;

	// Add data
	@PostMapping("/insert")
	public ResponseEntity<responseDTO> insert(@Valid @RequestBody CartDTO modeldto) {

		CartModel book = service.insert(modeldto);
		responseDTO response = new responseDTO("Book added successfully", book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.CREATED);

	}

	// Get data
	@GetMapping("/getAll")
	public ResponseEntity<responseDTO> getAll() {

		List<CartModel> cart = service.getAll();
		responseDTO response = new responseDTO("List of Cart", cart);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}
	
	// Get data by Id
	@GetMapping("/getById/{Id}")
	public ResponseEntity<responseDTO> getById(@PathVariable int Id) {

		CartModel cart = service.getById(Id);
		responseDTO response = new responseDTO("Cart for Id " + Id, cart);
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
	public ResponseEntity<responseDTO> updateById(@PathVariable int Id, @Valid @RequestBody CartDTO modeldto) {

		CartModel cart = service.updateById(Id, modeldto);
		responseDTO response = new responseDTO("Updated successfully", cart);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}
	
	// Update book quantity
	@PutMapping("/updateQuantity/{Id}")
	public ResponseEntity<responseDTO> updateQuantityById(@PathVariable int Id, @RequestParam String quantity) {

		CartModel cart = service.updateQuantityById(Id, quantity);
		responseDTO response = new responseDTO("Updated successfully", cart);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}

}