package com.RestApi.SpringBootApi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Dept_Id")
	private long dept_id;
	
	@Column(name="Dept_Name")
	private String dept_name;
	
	@JsonIgnore
	@ManyToOne
	private Employee employee;

	public long getDept_id() {
		return dept_id;
	}

	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department(long dept_id, String dept_name, Employee employee) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.employee = employee;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", employee=" + employee + "]";
	}
}
