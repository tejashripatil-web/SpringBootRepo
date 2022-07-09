package com.RestApi.SpringBootApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.RestApi.SpringBootApi.dto.EmpDetailsResponseDto;
import com.RestApi.SpringBootApi.dto.EmployeeReqDto;
import com.RestApi.SpringBootApi.entity.Address;
import com.RestApi.SpringBootApi.entity.Department;
import com.RestApi.SpringBootApi.entity.Employee;

@Service
public interface EmployeeService  {

	public List<Employee> getAllEmployee();

	public EmpDetailsResponseDto getEmployeeById(long id);

	public void deleteEmployee(long id);

	public Employee createEmployee(EmployeeReqDto dto);

	public Employee editEmployee(EmployeeReqDto dto, Long id);



}
