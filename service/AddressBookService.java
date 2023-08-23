package com.springboot.addressbookapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.addressbookapplication.dto.AddressBookDTO;
import com.springboot.addressbookapplication.entity.AddressBookModel;
import com.springboot.addressbookapplication.exception.AddressBookException;
import com.springboot.addressbookapplication.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	AddressBookRepository repository;

	@Override
	public AddressBookModel post(AddressBookDTO model) {
		AddressBookModel employee = new AddressBookModel(model);
		repository.save(employee);
		return employee;
	}

	@Override
	public List<AddressBookModel> get() {
		return repository.findAll();
	}

	@Override
	public AddressBookModel getById(int id) {
		Optional<AddressBookModel> employee = repository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} 
		else throw new AddressBookException("Employee Not Found");
	}

	@Override
	public AddressBookModel updateById(int id, AddressBookDTO model) {
		Optional<AddressBookModel> employee = repository.findById(id);
		if (employee.isPresent()) {
			employee.get().setEmpname(model.getEmpname());
			employee.get().setCity(model.getCity());
			employee.get().setState(model.getState());
			employee.get().setZip(model.getZip());
			employee.get().setEmail(model.getEmail());
			employee.get().setPhonenumber(model.getPhonenumber());
			repository.save(employee.get());
			return employee.get();
		} 
		else throw new AddressBookException("Employee Not Found");
	}

	@Override
	public String deleteById(int id) {
		Optional<AddressBookModel> employee = repository.findById(id);
		if (employee.isPresent()) {
			repository.deleteById(id);
			return "Deleted successfully";
		} 
		else throw new AddressBookException("Employee Not Found");
	}

	@Override
	public AddressBookModel getByEmail(String email) {
		Optional<AddressBookModel> employee = repository.findByEmail(email);
		if (employee.isPresent()) {
			return employee.get();
		} 
		else throw new AddressBookException("Employee Not Found");
	}

}
