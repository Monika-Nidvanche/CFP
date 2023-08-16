package com.springboot.employeeapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeeapplication.dto.HelloModelDTO;
import com.springboot.employeeapplication.entity.HelloModel;
import com.springboot.employeeapplication.repository.HelloRepository;

import jakarta.validation.Valid;

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
		return user.get();
	}

	@Override
	public String deleteUser(int id) {
		repository.deleteById(id);
		return "User deleted for Id " + id;
	}

	@Override
	public HelloModel update(int id, HelloModelDTO model) {
		HelloModel user = repository.findById(id).get();
		user.setName(model.getName());
		user.setGender(model.getGender());
		user.setStartDate(model.getStartDate());
		user.setSalary(model.getSalary());
		user.setProfilePic(model.getProfilePic());
		user.setDepartment(model.getDepartment());
		user.setNote(model.getNote());
		repository.save(user);
		return user;
	}

	@Override
	public HelloModel updatefirstname(int id, String firstname) {
		Optional<HelloModel> user = repository.findById(id);
		if (user.isPresent()) {
			user.get().setName(firstname);
		}
		repository.save(user.get());
		return user.get();

	}

}
