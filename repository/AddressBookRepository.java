package com.springboot.addressbookapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.addressbookapplication.entity.AddressBookModel;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Integer> {

	@Query(value = "select * from hello_model where email=:email", nativeQuery = true)
	Optional<AddressBookModel> findByEmail(String email);

}
