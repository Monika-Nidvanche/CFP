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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstoreapplication.dto.LoginDto;
import com.bookstore.bookstoreapplication.dto.UserDTO;
import com.bookstore.bookstoreapplication.dto.responseDTO;
import com.bookstore.bookstoreapplication.entity.UserModel;
import com.bookstore.bookstoreapplication.service.IUserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	IUserService service;

	// User Registration
	@PostMapping("/register")
	public ResponseEntity<responseDTO> register(@Valid @RequestBody UserDTO model) {

		UserModel user = service.register(model);
		responseDTO response = new responseDTO("Registration successful", user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.CREATED);

	}
	
	// Get data
	@GetMapping("/getAll")
	public ResponseEntity<responseDTO> getAll() {

		List<UserModel> user = service.getAll();
		responseDTO response = new responseDTO("List of User", user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}
	
	// Get data by Id
	@GetMapping("/getById/{Id}")
	public ResponseEntity<responseDTO> getById(@PathVariable int Id) {

		UserModel user = service.getById(Id);
		responseDTO response = new responseDTO("User for Id " + Id, user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}
	
	// Get data by Email
	@GetMapping("/getByEmailID/{Email}")
	public ResponseEntity<responseDTO> getByEmail(@PathVariable String Email) {

		UserModel user = service.getByEmail(Email);
		responseDTO response = new responseDTO("User for email " + Email, user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}
	
	// Delete data by Id
	@DeleteMapping("/deleteById/{Id}")
	public ResponseEntity<responseDTO> deleteById(@PathVariable int Id) {

		String user = service.deleteById(Id);
		responseDTO response = new responseDTO("Deleted", user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}
	
	// Update data by Email
	@PutMapping("/updateUserByEmail/{Email}")
	public ResponseEntity<responseDTO> updateByEmail(@PathVariable String Email, 
			@Valid @RequestBody UserDTO model) {

		UserModel user = service.updateByEmail(Email, model);
		responseDTO response = new responseDTO("Updated successfully", user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}
	
	// Get data by token
	@GetMapping("/getByToken/{token}")
	public ResponseEntity<responseDTO> getByToken(@PathVariable String token) {

		UserModel user = service.getByToken(token);
		responseDTO response = new responseDTO("User for Id " + user.getUserID(), user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);

	}
	
	// Login
	@GetMapping("/login")
	public ResponseEntity<responseDTO> login(@RequestBody LoginDto model) {

		String message = service.login(model);
		responseDTO response = new responseDTO("Login successful", message);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}
	
	// Reset password/forgot password
	@PutMapping("/forgotpassword")
	public ResponseEntity<responseDTO> forgotPassword(@RequestParam String email, 
			@RequestParam String newPassword) {

		String message = service.forgotPassword(email, newPassword);
		responseDTO response = new responseDTO("Password reset successful", message);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}
	
	// Reset password/change password
	@PutMapping("/resetPassword")
	public ResponseEntity<responseDTO> resetPassword(@RequestParam String email, 
			@RequestParam String password, @RequestParam String newPassword) {
		
		String message = service.resetPassword(email,password,newPassword);
		responseDTO response = new responseDTO("Password reset successful", message);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);

	}

}
