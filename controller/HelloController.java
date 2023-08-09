package com.springboot.employeeapplication.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeeapplication.dto.HelloModelDTO;
import com.springboot.employeeapplication.entity.HelloModel;
import com.springboot.employeeapplication.service.IHelloService;

@RestController
public class HelloController {

	@Autowired
	IHelloService service;

	@PostMapping("/post")
	public ResponseEntity<HelloModel> post(@RequestBody HelloModelDTO model) {
		HelloModel user = service.postUser(model);
		return new ResponseEntity<HelloModel>(user, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<HelloModel>> getAll() {
		List<HelloModel> list = service.getAllUser();
		return new ResponseEntity<List<HelloModel>>(list, HttpStatus.OK);
	}

	@GetMapping("/getByID/{Id}")
	public ResponseEntity<HelloModel> getByID(@PathVariable int Id) {
		HelloModel user = service.getUser(Id);
		return new ResponseEntity<HelloModel>(user, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByID/{Id}")
	public ResponseEntity<String> deleteByID(@PathVariable int Id) {
		String user = service.deleteUser(Id);
		return new ResponseEntity<String>(user, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateByID/{Id}")
	public ResponseEntity<HelloModel> update(@PathVariable int Id, @RequestBody HelloModelDTO model) {
		HelloModel user = service.update(Id, model);
		return new ResponseEntity<HelloModel>(user, HttpStatus.ACCEPTED);
	}

}
