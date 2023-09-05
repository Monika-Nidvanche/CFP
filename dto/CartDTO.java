package com.bookstore.bookstoreapplication.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDTO {
	
	private int userID;
	private int bookID;
	@NotEmpty
	private String quantity;

}
