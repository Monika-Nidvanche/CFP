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

	@Override
	public UserModel register(UserDTO model) {
		UserModel user = new UserModel(model);
		repository.save(user);
		String token = bookstoretoken.createToken(user.getUserID());
		System.out.println(token);
		emailsender.sendEmail(user.getEmail(), "Email for BookStore", "Hello "+
		user.getFirstName()+",\n\n"+"User name: "+user.getFirstName()+"\nUser address: "+
				user.getAddress()+"\nUser Dob: "+user.getDob()+
				"\nURL: "+"http://localhost:8080/getByToken/"+token);
		return user;
	}

	@Override
	public List<UserModel> getAll() {
		return repository.findAll();
	}

	@Override
	public UserModel getById(int id) {
		Optional<UserModel> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} 
		else throw new BookStoreException("User Not Found");
	}

	@Override
	public UserModel getByEmail(String email) {
		Optional<UserModel> user = repository.findByEmail(email);
		if (user.isPresent()) {
			return user.get();
		} 
		else throw new BookStoreException("User Not Found");
	}

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

	@Override
	public UserModel updateByEmail(String email, UserDTO model) {
		Optional<UserModel> user = repository.findByEmail(email);
		if (user.isPresent()) {
			user = Optional.of(new UserModel(user.get().getUserID(), model));
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
	
	@Override
	public UserModel getByToken(String token) {
		int userId = bookstoretoken.decodeToken(token);
		return repository.findById(userId).get();
	}

	@Override
	public String login(LoginDto model) {
		Optional<UserModel> user = repository.findByEmail(model.getEmail());
		if(user.isPresent() && user.get().getPassword().equals(model.getPassword())) {
			return "User login successful";
		}
		else throw new BookStoreException("Invalid username or password. "
				+ "Forgot password: http://localhost:8080/forgotpassword");
	}

	@Override
	public String forgotPassword(LoginDto model) {
		Optional<UserModel> user = repository.findByEmail(model.getEmail());
		if (user.isPresent()) {
			user.get().setPassword(model.getPassword());
			repository.save(user.get());
			emailsender.sendEmail(user.get().getEmail(), "Email for BookStore", 
			"Password reset successful");
			return "Password reset successful";
		} 
		else throw new BookStoreException("User Not Found");
	}

	@Override
	public String resetPassword(LoginDto model) {
		Optional<UserModel> user = repository.findByEmail(model.getEmail());
		if(user.isPresent() && user.get().getPassword().equals(model.getPassword())) {
			user.get().setPassword(model.getNewPassword());
			repository.save(user.get());
			return "Password reset successful";	
		}
		else throw new BookStoreException("Invalid username or password");
	}

}
