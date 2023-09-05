package com.bookstore.bookstoreapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstoreapplication.entity.CartModel;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Integer> {

}
