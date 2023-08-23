package com.springboot.addressbookapplication.service;

import java.util.List;

import com.springboot.addressbookapplication.dto.AddressBookDTO;
import com.springboot.addressbookapplication.entity.AddressBookModel;

public interface IAddressBookService {
	
	AddressBookModel post(AddressBookDTO model);

	List<AddressBookModel> get();

	AddressBookModel getById(int id);

	AddressBookModel updateById(int id, AddressBookDTO model);

	String deleteById(int id);

	AddressBookModel getByEmail(String email);

}
