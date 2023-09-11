package com.bookstore.bookstoreapplication.entity;

import java.util.Date;

import com.bookstore.bookstoreapplication.dto.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserID;

	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private Date dob;
	private String password;

	public UserModel(UserDTO modeldto) {
		this.firstName = modeldto.getFirstName();
		this.lastName = modeldto.getLastName();
		this.email = modeldto.getEmail();
		this.address = modeldto.getAddress();
		this.dob = modeldto.getDob();
		this.password = modeldto.getPassword();
	}

	public UserModel(int userId, UserDTO modeldto) {
		this.UserID = userId;
		this.firstName = modeldto.getFirstName();
		this.lastName = modeldto.getLastName();
		this.email = modeldto.getEmail();
		this.address = modeldto.getAddress();
		this.dob = modeldto.getDob();
		this.password = modeldto.getPassword();
	}

}