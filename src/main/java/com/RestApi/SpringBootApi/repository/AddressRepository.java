package com.RestApi.SpringBootApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestApi.SpringBootApi.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findByEmployeeId(long id);
}
