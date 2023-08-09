package com.springboot.employeeapplication.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HelloModelDTO {

	private String name;
	private String gender;
	private Date startDate;
	private long salary;
	private String profilePic;
	private List<String> department;
	private String note;	
	
}
