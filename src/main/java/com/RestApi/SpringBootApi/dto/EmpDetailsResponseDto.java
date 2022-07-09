package com.RestApi.SpringBootApi.dto;

import java.util.Set;

import com.RestApi.SpringBootApi.entity.Address;
import com.RestApi.SpringBootApi.entity.Department;

public class EmpDetailsResponseDto {

	private long id;

	private String first_name;

	private String last_name;

	private Set<AddressDetailsDto> address;

	private Set<DepartmentDetailsDto> department;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Set<AddressDetailsDto> getAddress() {
		return address;
	}

	public void setAddress(Set<AddressDetailsDto> address) {
		this.address = address;
	}

	public Set<DepartmentDetailsDto> getDepartment() {
		return department;
	}

	public void setDepartment(Set<DepartmentDetailsDto> department) {
		this.department = department;
	}
	
	

}
