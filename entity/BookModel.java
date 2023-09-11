package com.bookstore.bookstoreapplication.entity;

import com.bookstore.bookstoreapplication.dto.BookDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BookModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	
	private String bookName;
	private String autherName;
	private String bookDescription;
	private String bookImg;
	private String price;
	private String quantity;
	
	public BookModel(BookDTO model) {
		this.bookName = model.getBookName();
		this.autherName = model.getAutherName();
		this.bookDescription = model.getBookDescription();
		this.bookImg = model.getBookImg();
		this.price = model.getPrice();
		this.quantity = model.getQuantity();
	}

	public BookModel(int bookID, BookDTO model) {
		this.bookId = bookID;
		this.bookName = model.getBookName();
		this.autherName = model.getAutherName();
		this.bookDescription = model.getBookDescription();
		this.bookImg = model.getBookImg();
		this.price = model.getPrice();
		this.quantity = model.getQuantity();
	}

}
