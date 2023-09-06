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

import com.bookstore.bookstoreapplication.dto.BookDTO;
import com.bookstore.bookstoreapplication.dto.responseDTO;
import com.bookstore.bookstoreapplication.entity.BookModel;
import com.bookstore.bookstoreapplication.service.IBookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	IBookService service;

	// Add data
	@PostMapping("/insert")
	public ResponseEntity<responseDTO> insert(@Valid @RequestBody BookDTO model) {

		BookModel book = service.insert(model);
		responseDTO response = new responseDTO("Book added successfully", book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.CREATED);

	}

	// Get data
	@GetMapping("/getAll")
	public ResponseEntity<responseDTO> getAll() {

		List<BookModel> book = service.getAll();
		responseDTO response = new responseDTO("List of Book", book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}

	// Get data by Id
	@GetMapping("/getById/{Id}")
	public ResponseEntity<responseDTO> getById(@PathVariable int Id) {

		BookModel book = service.getById(Id);
		responseDTO response = new responseDTO("Book for Id " + Id, book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}
	
	// Delete data by Id
	@DeleteMapping("/deleteById/{Id}")
	public ResponseEntity<responseDTO> deleteById(@PathVariable int Id) {

		String book = service.deleteById(Id);
		responseDTO response = new responseDTO("Deleted", book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}
	
	// Update data by Id
	@PutMapping("/updateBookById/{Id}")
	public ResponseEntity<responseDTO> updateById(@PathVariable int Id, @Valid @RequestBody BookDTO model) {

		BookModel book = service.updateById(Id, model);
		responseDTO response = new responseDTO("Updated successfully", book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}

	// Search by book name
	@GetMapping("/searchByBookName/{bookname}")
	public ResponseEntity<responseDTO> searchByName(@PathVariable String bookname) {

		List<BookModel> book = service.searchByName(bookname);
		responseDTO response = new responseDTO("List of book", book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}
	
	// Update book quantity
	@PutMapping("/updateQuantity/{Id}")
	public ResponseEntity<responseDTO> updateQuantityById(@PathVariable int Id, 
			@RequestParam String quantity) {

		BookModel book = service.updateQuantityById(Id, quantity);
		responseDTO response = new responseDTO("Updated successfully", book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}
	
	// Get data by Ascending order
	@GetMapping("/sortingAsce")
	public ResponseEntity<responseDTO> sortingAsce() {

		List<BookModel> book = service.sortingAsce();
		responseDTO response = new responseDTO("List of book", book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}
	
	// Get data by Descending order
	@GetMapping("/sortingDesc")
	public ResponseEntity<responseDTO> sortingDesc() {

		List<BookModel> book = service.sortingDesc();
		responseDTO response = new responseDTO("List of book", book);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}

}
