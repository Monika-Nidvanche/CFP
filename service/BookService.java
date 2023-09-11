package com.bookstore.bookstoreapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstoreapplication.dto.BookDTO;
import com.bookstore.bookstoreapplication.entity.BookModel;
import com.bookstore.bookstoreapplication.exception.BookStoreException;
import com.bookstore.bookstoreapplication.repository.BookRepository;

@Service
public class BookService implements IBookService {
	
	@Autowired
	BookRepository repository;

	// Add data
	@Override
	public BookModel insert(BookDTO modeldto) {
		BookModel book = new BookModel(modeldto);
		repository.save(book);
		return book;
	}

	// Get data
	@Override
	public List<BookModel> getAll() {
		return repository.findAll();
	}

	// Get data by Id
	@Override
	public BookModel getById(int id) {
		Optional<BookModel> book = repository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} 
		else throw new BookStoreException("Book Not Found");
	}

	// Delete data by Id
	@Override
	public String deleteById(int id) {
		Optional<BookModel> book = repository.findById(id);
		if (book.isPresent()) {
			repository.deleteById(id);
			return "Deleted successfully";
		} 
		else throw new BookStoreException("Book Not Found");
	}

	// Update data by Id
	@Override
	public BookModel updateById(int id, BookDTO modeldto) {
		Optional<BookModel> book = repository.findById(id);
		if (book.isPresent()) {
			book = Optional.of(new BookModel(book.get().getBookId(), modeldto));
			repository.save(book.get());
			return book.get();
		} 
		else throw new BookStoreException("Book Not Found");
	}

	// Search by book name
	@Override
	public List<BookModel> searchByName(String bookname) {
		Optional<List<BookModel>> book = repository.findByBookName(bookname);
		return book.get();
	}

	// Update book quantity
	@Override
	public BookModel updateQuantityById(int id, String quantity) {
		Optional<BookModel> book = repository.findById(id);
		if (book.isPresent()) {
			book.get().setQuantity(quantity);
			repository.save(book.get());
			return book.get();
		} 
		else throw new BookStoreException("Book Not Found");
	}

	// Get data by Ascending order
	@Override
	public List<BookModel> sortingAsce() {
		return repository.findAll();
	}

	// Get data by Descending order
	@Override
	public List<BookModel> sortingDesc() {
		Optional<List<BookModel>> book = repository.sortingDesc();
		return book.get();
	}

}
