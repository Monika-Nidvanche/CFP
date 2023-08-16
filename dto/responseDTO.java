package com.springboot.employeeapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class responseDTO {
	
	private String message;
	private Object data;
	
}
