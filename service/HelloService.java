package com.springboot.employeeapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeeapplication.dto.HelloModelDTO;
import com.springboot.employeeapplication.entity.HelloModel;
import com.springboot.employeeapplication.exception.EmployeeApplicationException;
import com.springboot.employeeapplication.repository.HelloRepository;

@Service
public class HelloService implements IHelloService {

	@Autowired
	HelloRepository repository;

	@Override
	public HelloModel postUser(HelloModelDTO model) {
		HelloModel user = new HelloModel(model);
		repository.save(user);
		return user;
	}

	@Override
	public List<HelloModel> getAllUser() {
		return repository.findAll();
	}

	@Override
	public HelloModel getUser(int id) {
		Optional<HelloModel> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} 
		else throw new EmployeeApplicationException("Employee Not Found");
	}

	@Override
	public String deleteUser(int id) {
		Optional<HelloModel> user = repository.findById(id);
		if (user.isPresent()) {
			repository.deleteById(id);
			return "User deleted for Id " + id;
		} 
		else throw new EmployeeApplicationException("Employee Not Found");
	}

	@Override
	public HelloModel update(int id, HelloModelDTO model) {
		Optional<HelloModel> user = repository.findById(id);
		if (user.isPresent()) {
			HelloModel updateuser = new HelloModel(model);
			repository.save(updateuser);
			return updateuser;
		} 
		else throw new EmployeeApplicationException("Employee Not Found");
	}

	@Override
	public HelloModel updatefirstname(int id, String firstname) {
		Optional<HelloModel> user = repository.findById(id);
		if (user.isPresent()) {
			user.get().setName(firstname);
			repository.save(user.get());
			return user.get();
		}
		else throw new EmployeeApplicationException("Employee Not Found");
		
	}

}
