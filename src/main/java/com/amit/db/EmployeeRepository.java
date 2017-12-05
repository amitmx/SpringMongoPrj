package com.amit.db;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String>{
	
	public List<Employee> findByfirstName(String firstName);

	public List<Employee> findBylastName(String lastName);
	

}
