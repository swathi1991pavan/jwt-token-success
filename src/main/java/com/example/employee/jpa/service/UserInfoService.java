package com.example.employee.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.employee.jpa.model.UserInfo;
import com.example.employee.jpa.repository.EmployeeJpaRepository;
import com.example.employee.jpa.repository.UserInfoJpaRepository;
import com.example.employee.jpa.repository.UserInfoRepository;
@Service
public class UserInfoService implements UserInfoRepository{
	
	@Autowired
    private UserInfoJpaRepository repository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	 public String addUser(UserInfo userInfo) { 
		 userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		 repository.save( userInfo);
		 return "user added to system";
	 }

	
}
