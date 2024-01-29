package com.example.demo.service;

import com.example.demo.entity.Users;

public interface UserService {
	public String UserAdd(Users user);
	public boolean emailExist(String email);
	public boolean ValidateUser(String email,String password);
	public String getRole(String email);
	public Users getUser(String email);
	public void updateUser(Users user);

}
