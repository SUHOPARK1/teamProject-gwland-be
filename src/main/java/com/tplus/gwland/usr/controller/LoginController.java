package com.tplus.gwland.usr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@GetMapping("http://localhost:8080/login/oauth2/code/naver/redirect")
	public String login(@RequestParam String code,@RequestParam String state) {
		System.out.println("----"+code+state);
		return "";
	}
}
