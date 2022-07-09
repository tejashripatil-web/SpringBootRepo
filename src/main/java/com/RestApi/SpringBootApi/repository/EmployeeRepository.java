package com.RestApi.SpringBootApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestApi.SpringBootApi.dto.EmployeeReqDto;
import com.RestApi.SpringBootApi.entity.Address;
import com.RestApi.SpringBootApi.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
	
}
