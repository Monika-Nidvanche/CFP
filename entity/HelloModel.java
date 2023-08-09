package com.springboot.employeeapplication.entity;

import java.util.Date;
import java.util.List;

import com.springboot.employeeapplication.dto.HelloModelDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class HelloModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	
	private String name;
	private String gender;
	private Date startDate;
	private long salary;
	private String profilePic;
	private List<String> department;
	private String note;

	public HelloModel(HelloModelDTO model) {
		this.name = model.getName();
		this.gender = model.getGender();
		this.startDate = model.getStartDate();
		this.salary = model.getSalary();
		this.profilePic = model.getProfilePic();
		this.department = model.getDepartment();
		this.note = model.getNote();

	}

}
