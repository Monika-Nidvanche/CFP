package com.bookstore.bookstoreapplication.service;

import java.util.List;

import com.bookstore.bookstoreapplication.dto.LoginDto;
import com.bookstore.bookstoreapplication.dto.UserDTO;
import com.bookstore.bookstoreapplication.entity.UserModel;

public interface IUserService {

	// User Registration
	UserModel register(UserDTO modeldto);

	// Get data
	List<UserModel> getAll();

	// Get data by Id
	UserModel getById(int id);

	// Get data by Email
	UserModel getByEmail(String email);

	// Delete data by Id
	String deleteById(int id);

	// Update data by Email
	UserModel updateByEmail(String email, UserDTO modeldto);
	
	// Get data by token
	UserModel getByToken(String token);

	// Login
	String login(LoginDto modeldto);

	// Reset password/forgot password
	String forgotPassword(String email, String newPassword);

	// Reset password/change password
	String resetPassword(String email, String password, String newPassword);

}
