package com.example.employee.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity

@Table(name = "employees")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="EmployeeId")
	private int employeeId;
	
	@Column (name="EmployeeName" ,nullable=false, length=50)
	@NotEmpty(message = "user name shouldn't be null")
	@Size(min = 3,max=50 , message= "Size should be between 3 to 50")
	private String employeeName;
	
	@Column (name="Email" )
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}" , message = "invalid email address")
	private String email;
	
	@Column (name="Department" , nullable=false, length=50)
	@NotEmpty (message ="shouldn't be null")
	@Size(min = 3,max=50 , message = "Size should be between 3 to 50")
	private String department;
	
	public Employee(){}
	
	public Employee(int employeeId, String employeeName, String email, String department) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

}