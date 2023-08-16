package com.springboot.employeeapplication.dto;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HelloModelDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{3,}$", message = "Enter valid name")
	private String name;
	private String gender;
	private Date startDate;
	@Min(value = 5000, message = "Enter salary more than 5K")
	private long salary;
	private String profilePic;
	@NotEmpty
	private List<String> department;
	private String note;

}
