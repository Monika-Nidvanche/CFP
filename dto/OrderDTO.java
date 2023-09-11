package com.bookstore.bookstoreapplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
	
	private int totalPrice;
	private int quantity;
	private String address;
	private int userID;//https://www.youtube.com/watch?v=VuE7lq9sxSw
	private int bookID;//https://www.youtube.com/watch?v=VuE7lq9sxSw
	private boolean cancel;

}
