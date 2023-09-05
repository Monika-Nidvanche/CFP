package com.bookstore.bookstoreapplication.service;

import java.util.List;

import com.bookstore.bookstoreapplication.dto.BookDTO;
import com.bookstore.bookstoreapplication.entity.BookModel;

public interface IBookService {

	BookModel insert(BookDTO model);

	List<BookModel> getAll();

	BookModel getById(int id);

	String deleteById(int id);

	BookModel updateById(int id, BookDTO model);

	List<BookModel> searchByName(String bookName);

	BookModel updateQuantityById(int id, String quantity);

	List<BookModel> sortingAsce();

	List<BookModel> sortingDesc();

}
