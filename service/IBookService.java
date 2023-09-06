package com.bookstore.bookstoreapplication.service;

import java.util.List;

import com.bookstore.bookstoreapplication.dto.BookDTO;
import com.bookstore.bookstoreapplication.entity.BookModel;

public interface IBookService {

	// Add data
	BookModel insert(BookDTO model);

	// Get data
	List<BookModel> getAll();

	// Get data by Id
	BookModel getById(int id);

	// Delete data by Id
	String deleteById(int id);

	// Update data by Id
	BookModel updateById(int id, BookDTO model);

	// Search by book name
	List<BookModel> searchByName(String bookname);

	// Update book quantity
	BookModel updateQuantityById(int id, String quantity);

	// Get data by Ascending order
	List<BookModel> sortingAsce();

	// Get data by Descending order
	List<BookModel> sortingDesc();

}
