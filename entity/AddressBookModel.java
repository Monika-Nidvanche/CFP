package com.springboot.addressbookapplication.entity;

import com.springboot.addressbookapplication.dto.AddressBookDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressBookModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empID;

	private String empname;
	private String city;
	private String state;
	private int zip;
	private String email;
	private Long phonenumber;

	public AddressBookModel(AddressBookDTO model) {
		this.empname = model.getEmpname();
		this.city = model.getCity();
		this.state = model.getState();
		this.zip = model.getZip();
		this.email = model.getEmail();
		this.phonenumber = model.getPhonenumber();
	}

}
