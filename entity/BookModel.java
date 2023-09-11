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
	
	public BookModel(BookDTO modeldto) {
		this.bookName = modeldto.getBookName();
		this.autherName = modeldto.getAutherName();
		this.bookDescription = modeldto.getBookDescription();
		this.bookImg = modeldto.getBookImg();
		this.price = modeldto.getPrice();
		this.quantity = modeldto.getQuantity();
	}

	public BookModel(int bookID, BookDTO modeldto) {
		this.bookId = bookID;
		this.bookName = modeldto.getBookName();
		this.autherName = modeldto.getAutherName();
		this.bookDescription = modeldto.getBookDescription();
		this.bookImg = modeldto.getBookImg();
		this.price = modeldto.getPrice();
		this.quantity = modeldto.getQuantity();
	}

}