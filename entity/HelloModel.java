package com.springboot.employeeapplication.entity;

import java.util.Date;
import java.util.List;

import com.springboot.employeeapplication.dto.HelloModelDTO;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class HelloModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int employeeId;
	
	private String name;
	private String gender;
	private Date startDate;
	private long salary;
	private String profilePic;
	private String note;
	
	@ElementCollection
	@CollectionTable(name="emp_department", joinColumns = @JoinColumn(name="dID"))
	private List<String> department;

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
