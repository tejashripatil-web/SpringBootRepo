package com.RestApi.SpringBootApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestApi.SpringBootApi.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{

	List<Department> findByEmployee(long id);

	List<Department> findByEmployeeId(long id);


}
