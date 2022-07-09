package com.RestApi.SpringBootApi.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Emp_Id")
	private long id;
	
	@Column(name="First_Name")
	private String first_name;
	
	@Column(name="Last_Name")
	private String last_name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="Add_Id")
	private Set<Address> address=new HashSet<>();
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="Dept_Id")
	private Set<Department> department=new HashSet<>();

    

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


	public Set<Address> getAddress() {
		return address;
	}


	public void setAddress(Set<Address> address) {
		this.address = address;
	}


	public Set<Department> getDepartment() {
		return department;
	}


	public void setDepartment(Set<Department> department) {
		this.department = department;
	}
	

	public Employee(long id, String first_name, String last_name, Set<Address> address, Set<Department> department) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.department = department;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address
				+ ", department=" + department + "]";
	}
}
