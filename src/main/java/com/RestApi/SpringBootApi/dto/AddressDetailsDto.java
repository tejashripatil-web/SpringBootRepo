package com.RestApi.SpringBootApi.dto;

import javax.persistence.Column;

public class AddressDetailsDto {

	private long Add_id;

	private String city;

	private String state;

	private String country;

	public long getAdd_id() {
		return Add_id;
	}

	public void setAdd_id(long add_id) {
		Add_id = add_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
