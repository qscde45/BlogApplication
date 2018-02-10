package com.tianmaying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}