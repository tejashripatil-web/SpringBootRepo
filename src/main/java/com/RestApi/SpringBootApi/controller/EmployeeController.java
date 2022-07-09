package com.RestApi.SpringBootApi.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.SpringBootApi.dto.EmpDetailsResponseDto;
import com.RestApi.SpringBootApi.dto.EmployeeReqDto;
import com.RestApi.SpringBootApi.entity.Address;
import com.RestApi.SpringBootApi.entity.Employee;
import com.RestApi.SpringBootApi.service.EmployeeService;

@RestController
public class EmployeeController{
	
	@Autowired EmployeeService employeeService;
	
	
	@GetMapping("/emp")
	public List<Employee> getAllEmployee()
	{
		 List<Employee> list = employeeService.getAllEmployee();
		 return list;
	}
	
	@GetMapping("/emp/{id}")
	public EmpDetailsResponseDto getEmployeeById(@PathVariable Long id)
	{
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/emp")
	public Employee createEmployee(@RequestBody EmployeeReqDto dto)
	{   
		
		return employeeService.createEmployee(dto);		
		
	}
	
	@PutMapping("/emp/{id}")
	public Employee editEmployee(@RequestBody EmployeeReqDto dto,@PathVariable(value="id") Long id)
	{

		return employeeService.editEmployee(dto,id);
	}
	
	@DeleteMapping("/emp/{id}")
	public void deleteEmployee(@PathVariable(value="id") Long id)
	{
		 employeeService.deleteEmployee(id);
	}	
}
