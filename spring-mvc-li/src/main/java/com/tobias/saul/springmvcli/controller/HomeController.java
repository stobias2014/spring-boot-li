package com.tobias.saul.springmvcli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping(path = "home")
	public String goHome() {
		System.out.println("Inside of home controller");
		return "index";
	}

}
