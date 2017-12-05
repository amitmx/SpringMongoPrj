package com.amit.db;

import org.springframework.data.annotation.Id;

public class Employee 
{
	@Id
	public String id;
	public String firstName;
	public String lastName;
	
	public Employee()
	{
		
	}

    public Employee(String firstName, String lastName) {
    		System.out.println("Here");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
	
	

}
