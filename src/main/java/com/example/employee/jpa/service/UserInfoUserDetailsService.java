package com.example.employee.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.employee.jpa.model.UserInfo;
import com.example.employee.jpa.model.UserInfoUserDetails;
import com.example.employee.jpa.repository.UserInfoJpaRepository;


@Service
public class UserInfoUserDetailsService implements UserDetailsService{
	
	@Autowired
    private UserInfoJpaRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = repository.findByName(username);
		return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(()-> new UsernameNotFoundException("user not found" + username));
		
		
	}
	
	

}
