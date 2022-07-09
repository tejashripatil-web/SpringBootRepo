package com.RestApi.SpringBootApi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Address")
public class Address {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)

	private long Add_id;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Country")
	private String country;
	
	@JsonIgnore
	@ManyToOne()
	private Employee employee;

	public long getId() {
		return Add_id;
	}

	public void setId(long id) {
		this.Add_id = id;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Address(long id, String city, String state, String country, Employee employee) {
		super();
		this.Add_id = id;
		this.city = city;
		this.state = state;
		this.country = country;
		this.employee = employee;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Address [id=" + Add_id + ", city=" + city + ", state=" + state + ", country=" + country + ", employee="
				+ employee + "]";
	}
}
