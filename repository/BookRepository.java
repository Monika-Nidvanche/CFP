package com.bookstore.bookstoreapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstoreapplication.entity.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {

	// Search by book name
	@Query(value="select * from book_model where book_name like :bookname% order by "
			+ "replace(book_name,' ','')", nativeQuery = true)
	Optional<List<BookModel>> findByBookName(String bookname);

	// Get data by descending order
	@Query(value="select * from book_model order by book_id desc", nativeQuery = true)
	Optional<List<BookModel>> sortingDesc();

}
