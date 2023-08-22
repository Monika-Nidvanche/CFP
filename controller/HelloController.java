package com.springboot.employeeapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeeapplication.dto.HelloModelDTO;
import com.springboot.employeeapplication.dto.responseDTO;
import com.springboot.employeeapplication.entity.HelloModel;
import com.springboot.employeeapplication.service.IHelloService;

import jakarta.validation.Valid;

@RestController
public class HelloController {

	@Autowired
	IHelloService service;

	@PostMapping("/post")
	public ResponseEntity<responseDTO> post(@Valid @RequestBody HelloModelDTO model) {
		HelloModel user = service.postUser(model);
		responseDTO response = new responseDTO("User added",user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<responseDTO> getAll() {
		List<HelloModel> list = service.getAllUser();
		responseDTO response = new responseDTO("List of user",list);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);
	}

	@GetMapping("/getByID/{Id}")
	public ResponseEntity<responseDTO> getByID(@PathVariable int Id) {
		HelloModel user = service.getUser(Id);
		responseDTO response = new responseDTO("User for Id "+user.getEmployeeId(),user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByID/{Id}")
	public ResponseEntity<responseDTO> deleteByID(@PathVariable int Id) {
		String user = service.deleteUser(Id);
		responseDTO response = new responseDTO("User deleted",user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateByID/{Id}")
	public ResponseEntity<responseDTO> update(@PathVariable int Id,@Valid @RequestBody HelloModelDTO model) {
		HelloModel user = service.update(Id, model);
		responseDTO response = new responseDTO("User updated",user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updatefirstname/{id}")
	public ResponseEntity<responseDTO> updateFirstname(@PathVariable int id, @RequestParam String firstname) {
	
		HelloModel user = service.updatefirstname(id, firstname);
		responseDTO response = new responseDTO("Firstname updated for Id "+user.getEmployeeId(),user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.ACCEPTED);	
		
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<responseDTO> getByName(@PathVariable String name){
		HelloModel user = service.getbyname(name);
		responseDTO response = new responseDTO("User for name "+user.getName(),user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/deptByName/{dept}")
	public ResponseEntity<responseDTO> deptByName(@PathVariable String dept){
		List<HelloModel> user = service.deptbyname(dept);
		responseDTO response = new responseDTO("User for department "+dept,user);
		return new ResponseEntity<responseDTO>(response, HttpStatus.OK);
	}

}
