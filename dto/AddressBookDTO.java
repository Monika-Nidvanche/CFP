package com.springboot.addressbookapplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{3,}$", message = "Enter valid name")
	private String empname;
	private String city;
	private String state;
	private int zip;
	@Email
	private String email;
	private Long phonenumber;

}
