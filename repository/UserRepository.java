package com.bookstore.bookstoreapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstoreapplication.entity.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

	// Get data by Email
	Optional<UserModel> findByEmail(String email);

}
