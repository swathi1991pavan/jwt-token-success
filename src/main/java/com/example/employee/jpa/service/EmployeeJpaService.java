package com.example.employee.jpa.service;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.example.employee.jpa.model.Employee;
import com.example.employee.jpa.repository.EmployeeJpaRepository;
import com.example.employee.jpa.repository.EmployeeRepository;

@Service
public class EmployeeJpaService implements EmployeeRepository{
	
	@Autowired
    private EmployeeJpaRepository employeeJpaRepository;

	@Override
	public ArrayList<Employee> getEmployees() {
		List<Employee> employeeList = employeeJpaRepository.findAll();
        ArrayList<Employee> employees = new ArrayList<>(employeeList);
        return employees;
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		employeeJpaRepository.save(employee);
	    return employee;
	}

	 @Override
	 public Employee getEmployeeById(int employeeId) {
		 try {
			 Employee employee = employeeJpaRepository.findById(employeeId).get();
			 return employee;
		 }catch(Exception e) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Check the id");
		 }
		
		 
	 }
	

	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
		try {
			
			Employee existingEmployee =employeeJpaRepository.findById(employeeId).get();
			if(existingEmployee != null) {
				
				if(employee.getEmployeeName() != null){
					existingEmployee.setEmployeeName(employee.getEmployeeName());
				}   
		        				
		        if(employee.getEmail() != null){		            
		            existingEmployee.setEmail(employee.getEmail());
		        }
		        
				if(employee.getDepartment() !=null) {					
					existingEmployee.setDepartment(employee.getDepartment());
				}
				
				
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);			
		}
		
		
		return getEmployeeById(employeeId);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		try {
			
			Employee employee = getEmployeeById(employeeId);
			
			if(employee != null) {
				employeeJpaRepository.deleteById(employeeId);				
			}
			
		}catch (Exception e) {			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

	
	
	

}
