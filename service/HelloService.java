package com.springboot.springbootproject.service;

import org.springframework.stereotype.Service;

import com.springboot.springbootproject.entity.HelloModel;

@Service
public class HelloService implements IHelloService  {

	@Override
	public String getServiceMethod() {
		
		return "Controller API";
	}

	@Override
	public String helloworld() {
		String res = "hello world";
		return res;
	}

	@Override
	public String addData(HelloModel model) {
		String val = "My name is "+model.getFirstName()+" "+model.getLastName()+". "
				+ "My salary is "+model.getSalary();
		return val;
	}

	@Override
	public String postData(String firstName, String lastName, int salary) {
		String val = "My updated name is "+firstName+" "+lastName+". "
				+ "My salary is "+salary;
		return val;
	}
	
}
