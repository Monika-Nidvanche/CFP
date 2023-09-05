package com.bookstore.bookstoreapplication.service;

import java.util.List;

import com.bookstore.bookstoreapplication.dto.LoginDto;
import com.bookstore.bookstoreapplication.dto.UserDTO;
import com.bookstore.bookstoreapplication.entity.UserModel;

public interface IUserService {

	UserModel register(UserDTO model);

	List<UserModel> getAll();

	UserModel getById(int id);

	UserModel getByEmail(String email);

	String deleteById(int id);

	UserModel updateByEmail(String email, UserDTO model);
	
	UserModel getByToken(String token);

	String login(LoginDto model);

	String forgotPassword(LoginDto model);

	String resetPassword(LoginDto model);

}
