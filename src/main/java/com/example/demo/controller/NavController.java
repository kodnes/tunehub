package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/login")
	public String getLoginPage()
	{
		return "login";
	}
	@GetMapping("/register")
	public String getRegisterPage()
	{
		return "register";
	}
	@GetMapping("/newSong")
	public String newSong()
	{
		return "newSong";
	}
	

}
