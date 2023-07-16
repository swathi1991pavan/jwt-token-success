package com.example.employee.jpa.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.employee.jpa.model.Employee;
import com.example.employee.jpa.service.EmployeeJpaService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
	
	@Autowired
    public EmployeeJpaService employeeService ;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ArrayList<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("{employeeId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId){
		return employeeService.getEmployeeById(employeeId);
    } 
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("{employeeId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Employee updateEmployee(@PathVariable("employeeId")  int employeeId , @RequestBody Employee employee) {
		return employeeService.updateEmployee(employeeId, employee);
	}
	
	@DeleteMapping("{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
	
	
	
}
