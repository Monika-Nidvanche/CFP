package com.springboot.addressbookapplication.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.springboot.addressbookapplication.dto.AddressBookDTO;
import com.springboot.addressbookapplication.dto.responseDTO;
import com.springboot.addressbookapplication.entity.AddressBookModel;
import com.springboot.addressbookapplication.service.IAddressBookService;

import jakarta.validation.Valid;

@RestController
public class AddressBookController {

	@Autowired
	IAddressBookService service;

	@PostMapping("/post")
	public ResponseEntity<responseDTO> post(@Valid @RequestBody AddressBookDTO model) {

		AddressBookModel employee = service.post(model);
		responseDTO response = new responseDTO("Employee added successfully", employee);
		return new ResponseEntity<responseDTO>(response, HttpStatus.CREATED);

	}

	@GetMapping("/get")
	public ResponseEntity<responseDTO> get() {

		List<AddressBookModel> employee = service.get();
		responseDTO response = new responseDTO("List of Employee", employee);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getById/{Id}")
	public ResponseEntity<responseDTO> getById(@PathVariable int Id) {

		AddressBookModel employee = service.getById(Id);
		responseDTO response = new responseDTO("Employee for Id " + Id, employee);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}

	@PutMapping("/updateById/{Id}")
	public ResponseEntity<responseDTO> updateById(@PathVariable int Id, @Valid @RequestBody AddressBookDTO model) {

		AddressBookModel employee = service.updateById(Id, model);
		responseDTO response = new responseDTO("Updated successfully", employee);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}

	@DeleteMapping("/deleteById/{Id}")
	public ResponseEntity<responseDTO> deleteById(@PathVariable int Id) {

		String employee = service.deleteById(Id);
		responseDTO response = new responseDTO("Deleted", employee);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getByEmail/{Email}")
	public ResponseEntity<responseDTO> getByEmail(@PathVariable String Email) {

		AddressBookModel employee = service.getByEmail(Email);
		responseDTO response = new responseDTO("Employee for email " + Email, employee);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}

}
