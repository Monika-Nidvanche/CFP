package com.bookstore.bookstoreapplication.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{3,}$", message = "Enter valid name")
	private String firstName;
	private String lastName;
	@Email
	@NotEmpty
	private String email;
	private String address;
	private Date dob;
	@NotEmpty
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,}$", 
	message = "Enter valid password")
	private String password;

}
