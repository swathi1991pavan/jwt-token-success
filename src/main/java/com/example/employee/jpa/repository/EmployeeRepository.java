package com.example.employee.jpa.repository;

import java.util.ArrayList;


import com.example.employee.jpa.model.Employee;

public interface EmployeeRepository {
	
	ArrayList<Employee> getEmployees();
	
	Employee addEmployee(Employee employee);
	
	Employee getEmployeeById(int employeeId) ;
	
    Employee updateEmployee(int employeeId,Employee employee);
	
	void deleteEmployee(int employeeId);
	
	

}
