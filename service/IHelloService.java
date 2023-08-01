package com.springboot.springbootproject.service;

import com.springboot.springbootproject.entity.HelloModel;

public interface IHelloService {

	String getServiceMethod();

	String helloworld();

	String addData(HelloModel model);

	String postData(String firstName, String lastName, int salary);

}
