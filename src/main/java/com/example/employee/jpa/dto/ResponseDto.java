package com.example.employee.jpa.dto;

public class ResponseDto {
	private UserDto user;
	
	public ResponseDto() {}
	
	public ResponseDto(UserDto user) {
		super();
		this.user = user;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
}
