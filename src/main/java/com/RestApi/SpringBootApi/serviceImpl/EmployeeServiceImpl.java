package com.RestApi.SpringBootApi.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.RestApi.SpringBootApi.dto.AddressDetailsDto;
import com.RestApi.SpringBootApi.dto.DepartmentDetailsDto;
import com.RestApi.SpringBootApi.dto.EmpDetailsResponseDto;
import com.RestApi.SpringBootApi.dto.EmployeeReqDto;
import com.RestApi.SpringBootApi.entity.Address;
import com.RestApi.SpringBootApi.entity.Department;
import com.RestApi.SpringBootApi.entity.Employee;
import com.RestApi.SpringBootApi.repository.AddressRepository;
import com.RestApi.SpringBootApi.repository.DepartmentRepository;
import com.RestApi.SpringBootApi.repository.EmployeeRepository;
import com.RestApi.SpringBootApi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
   
	@Autowired EmployeeRepository employeeRepository;
	
	@Autowired DepartmentRepository departmentRepository;
	
	@Autowired AddressRepository addressRepository;
	

	@Override
	public EmpDetailsResponseDto getEmployeeById(long id)
	{
		Optional<Employee> emp =  employeeRepository.findById(id);
		EmpDetailsResponseDto dto = new EmpDetailsResponseDto();
		if(emp.isPresent()) {
			dto.setFirst_name(emp.get().getFirst_name());
			dto.setLast_name(emp.get().getLast_name());
			dto.setId(emp.get().getId());
			
			List<Address> addresses= addressRepository.findByEmployeeId(id);
			if(!addresses.isEmpty()) {
				Set<AddressDetailsDto> detailsDtos = new HashSet<AddressDetailsDto>();
				for (Address address : addresses) {
					AddressDetailsDto addDto = new AddressDetailsDto();
					addDto.setAdd_id(address.getId());
					addDto.setCity(address.getCity());
					addDto.setCountry(address.getCountry());
					addDto.setState(address.getState());
					//save in arraylist
					detailsDtos.add(addDto);
				}
			dto.setAddress(detailsDtos);		
			}	
		}
		List<Department> departments = departmentRepository.findByEmployeeId(id);
		if(!departments.isEmpty())
		{
			Set<DepartmentDetailsDto> detailDto = new HashSet<DepartmentDetailsDto>();
			for(Department department : departments)
			{
				DepartmentDetailsDto deptDto = new DepartmentDetailsDto();
				deptDto.setDept_id(department.getDept_id());
				deptDto.setDept_name(department.getDept_name());
				//save in arralist
				detailDto.add(deptDto);
			}
			dto.setDepartment(detailDto);
		}
		 return dto;
	}
	
	@Override
	public Employee createEmployee(EmployeeReqDto dto) 
	{
		Employee e = new Employee();
		e.setFirst_name(dto.getFirst_name());
		e.setLast_name(dto.getLast_name());
		
		//save employee
		 employeeRepository.save(e);
		 long empid = e.getId();
		 
		 Address address = new Address();
		 address.setCity(dto.getCity());
		 address.setCountry(dto.getCountry());
		 address.setState(dto.getState());
		 address.setEmployee(e);
		 
		 //save address
		 addressRepository.save(address);
		 
		 Department department = new Department();
		 department.setDept_name(dto.getDept_name());
		 department.setEmployee(e);
		 
		 departmentRepository.save(department);
		 return e;
	}	

	@Override
	public Employee editEmployee(EmployeeReqDto dto, Long id)
	{
		
		Optional<Employee> opReq=employeeRepository.findById(id);
		
		Employee e = opReq.get();
		e.setFirst_name(dto.getFirst_name());
		e.setLast_name(dto.getLast_name());
		
		//save employee
		 employeeRepository.save(e);
		 long empid = e.getId();
		 
		 Optional<Address> add = addressRepository.findById(id);
		 Address address=add.get();
		 address.setCity(dto.getCity());
		 address.setCountry(dto.getCountry());
		 address.setState(dto.getState());
		 address.setEmployee(e);
		 
		 //save address
		 addressRepository.save(address);
		 
		 Optional<Department> depart = departmentRepository.findById(id);
		 Department department=depart.get();
		 department.setDept_name(dto.getDept_name());
		 department.setEmployee(e);
		 
		 departmentRepository.save(department);
		 
		 return e;
	}

	@Override
	public void deleteEmployee(long id) 
	{ 
		
		List<Address> optAddress = addressRepository.findByEmployeeId(id);
		if(!optAddress.isEmpty()) {
			addressRepository.deleteAll(optAddress);
		}
		
		List<Department> optDepartment=departmentRepository.findByEmployeeId(id);
		if(!optDepartment.isEmpty())
		{
			departmentRepository.deleteAll(optDepartment);
		}
		
		Optional<Employee> e= employeeRepository.findById(id);
		employeeRepository.deleteById(id);

	}

	@Override
	public List<Employee> getAllEmployee() 
	{
		return employeeRepository.findAll();
		
	}
}
