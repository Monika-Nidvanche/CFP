package com.bookstore.bookstoreapplication.repository;

import java.util.List;
import java.util.Optional;
import java.util.SortedSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstoreapplication.entity.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {

	Optional<List<BookModel>> findByBookName(String bookName);

	@Query(value="select * from book_model order by book_id desc", nativeQuery = true)
	Optional<List<BookModel>> sortingDesc();

}
