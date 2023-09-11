package com.bookstore.bookstoreapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoreapplication.dto.LoginDto;
import com.bookstore.bookstoreapplication.dto.UserDTO;
import com.bookstore.bookstoreapplication.entity.UserModel;
import com.bookstore.bookstoreapplication.exception.BookStoreException;
import com.bookstore.bookstoreapplication.repository.UserRepository;
import com.bookstore.bookstoreapplication.util.BookStoreEmailSenderService;
import com.bookstore.bookstoreapplication.util.BookStoreToken;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	BookStoreToken bookstoretoken;
	
	@Autowired
	BookStoreEmailSenderService emailsender;

	// User Registration
	@Override
	public UserModel register(UserDTO modeldto) {
		UserModel user = new UserModel(modeldto);
		repository.save(user);
		String token = bookstoretoken.createToken(user.getUserID());
		System.out.println(token);
		emailsender.sendEmail(user.getEmail(), "Email for BookStore", "Hello "+
		user.getFirstName()+",\n\n"+"User name: "+user.getFirstName()+"\nUser address: "+
				user.getAddress()+"\nUser Dob: "+user.getDob()+
				"\nURL: "+"http://localhost:8080/getByToken/"+token);
		return user;
	}

	// Get data
	@Override
	public List<UserModel> getAll() {
		return repository.findAll();
	}

	// Get data by Id
	@Override
	public UserModel getById(int id) {
		Optional<UserModel> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} 
		else throw new BookStoreException("User Not Found");
	}

	// Get data by Email
	@Override
	public UserModel getByEmail(String email) {
		Optional<UserModel> user = repository.findByEmail(email);
		if (user.isPresent()) {
			return user.get();
		} 
		else throw new BookStoreException("User Not Found");
	}

	// Delete data by Id
	@Override
	public String deleteById(int id) {
		Optional<UserModel> user = repository.findById(id);
		String email = user.get().getEmail();
		String name = user.get().getFirstName();
		if (user.isPresent()) {
			repository.deleteById(id);
			emailsender.sendEmail(email, "Email for BookStore",
					"User deleted for name: "+name);
			return "Deleted successfully";
		} 
		else throw new BookStoreException("User Not Found");
	}

	// Update data by Email
	@Override
	public UserModel updateByEmail(String email, UserDTO modeldto) {
		Optional<UserModel> user = repository.findByEmail(email);
		if (user.isPresent()) {
			user = Optional.of(new UserModel(user.get().getUserID(), modeldto));
			repository.save(user.get());
			String token = bookstoretoken.createToken(user.get().getUserID());
			System.out.println(token);
			emailsender.sendEmail(user.get().getEmail(), "Email for BookStore", "Hello "+
					user.get().getFirstName() + ",\n\n" + "User name: " + 
					user.get().getFirstName() + "\nUser address: "
					+ user.get().getAddress() + "\nUser Dob: " + user.get().getDob() + "\nURL: "
					+ "http://localhost:8080/getByToken/" + token);
			return user.get();
		} 
		else throw new BookStoreException("User Not Found");
	}
	
	// Get data by token
	@Override
	public UserModel getByToken(String token) {
		int userId = bookstoretoken.decodeToken(token);
		return repository.findById(userId).get();
	}

	// Login
	@Override
	public String login(LoginDto modeldto) {
		Optional<UserModel> user = repository.findByEmail(modeldto.getEmail());
		if(user.isPresent() && user.get().getPassword().equals(modeldto.getPassword())) {
			String token = bookstoretoken.createToken(user.get().getUserID());
			System.out.println(token);
			return "User login successful";
		}
		else throw new BookStoreException("Invalid username or password. "
				+ "Forgot password: http://localhost:8080/forgotpassword");
	}

	// Reset password/forgot password
	@Override
	public String forgotPassword(String email, String newPassword) {
		Optional<UserModel> user = repository.findByEmail(email);
		if (user.isPresent()) {
			user.get().setPassword(newPassword);
			repository.save(user.get());
			emailsender.sendEmail(user.get().getEmail(), "Email for BookStore", 
			"Password reset successful");
			return "Password reset successful";
		} 
		else throw new BookStoreException("User Not Found");
	}

	// Reset password/change password
	@Override
	public String resetPassword(String email, String password, String newPassword) {
		Optional<UserModel> user = repository.findByEmail(email);
		if(user.isPresent() && user.get().getPassword().equals(password)) {
			user.get().setPassword(newPassword);
			repository.save(user.get());
			return "Password reset successful";	
		}
		else throw new BookStoreException("Invalid username or password");
	}

}
