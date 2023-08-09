package com.springboot.employeeapplication.service;

import java.util.List;

import com.springboot.employeeapplication.dto.HelloModelDTO;
import com.springboot.employeeapplication.entity.HelloModel;

public interface IHelloService {

	HelloModel postUser(HelloModelDTO model);

	List<HelloModel> getAllUser();

	HelloModel getUser(int id);

	String deleteUser(int id);

	HelloModel update(int id, HelloModelDTO model);

}
