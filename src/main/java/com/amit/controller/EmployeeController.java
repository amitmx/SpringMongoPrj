package com.amit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.ProjectStatus;
import com.amit.db.Employee;
import com.amit.db.EmployeeRepository;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeRepository repo; 
	
	@RequestMapping(method=RequestMethod.POST, value="/employee/save")
	public ProjectStatus addData(@RequestBody @Valid Employee employee)
	{
		//repo.save(new Employee("Alice", "Smith"));
		//repo.save(new Employee("Bob", "Smith"));
		repo.save(employee);
		return new ProjectStatus("Success..");
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/employee/getall")
	public List<Employee> getData()
	{
		//repo.deleteAll();
		List<Employee> employees = new ArrayList<>();
		repo.findAll().forEach(employees::add);
		return employees;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/employee/deleteall")
	public ProjectStatus cleanDB()
	{
		repo.deleteAll();
		return new ProjectStatus("Success..");
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/employee/firstName/{firstName}")
	public List<Employee> getEmployee(@PathVariable String firstName)
	{
		return repo.findByfirstName(firstName);
		
	}
	
	@RequestMapping (method=RequestMethod.GET, value="/employee/lastName/{lastName}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeByLastName(@PathVariable String lastName)
	{
		return repo.findBylastName(lastName);
	}

}
