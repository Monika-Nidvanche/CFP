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

	@Override
	public BookModel insert(BookDTO model) {
		BookModel book = new BookModel(model);
		repository.save(book);
		return book;
	}

	@Override
	public List<BookModel> getAll() {
		return repository.findAll();
	}

	@Override
	public BookModel getById(int id) {
		Optional<BookModel> book = repository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} 
		else throw new BookStoreException("Book Not Found");
	}

	@Override
	public String deleteById(int id) {
		Optional<BookModel> book = repository.findById(id);
		if (book.isPresent()) {
			repository.deleteById(id);
			return "Deleted successfully";
		} 
		else throw new BookStoreException("Book Not Found");
	}

	@Override
	public BookModel updateById(int id, BookDTO model) {
		Optional<BookModel> book = repository.findById(id);
		if (book.isPresent()) {
			book = Optional.of(new BookModel(book.get().getBookId(), model));
			repository.save(book.get());
			return book.get();
		} 
		else throw new BookStoreException("Book Not Found");
	}

	@Override
	public List<BookModel> searchByName(String bookName) {
		Optional<List<BookModel>> book = repository.findByBookName(bookName);
		return book.get();
	}

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

	@Override
	public List<BookModel> sortingAsce() {
		return repository.findAll();
	}

	@Override
	public List<BookModel> sortingDesc() {
		Optional<List<BookModel>> book = repository.sortingDesc();
		return book.get();
	}

}
