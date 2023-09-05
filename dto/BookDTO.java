package com.bookstore.bookstoreapplication.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\s]{2,}$", message = "Enter valid bookname")
	private String bookName;
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\s]{3,}$", message = "Enter valid auther name")
	private String autherName;
	private String bookDescription;
	private String bookImg;
	@NotEmpty
	private String price;
	@NotEmpty
	private String quantity;

}
