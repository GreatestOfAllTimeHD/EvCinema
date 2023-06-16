package com.evcinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//1번
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	//2번
//	@RequestMapping("/")
//	public String home() {
//		return "redirect:/main";
//	}
//	
//	@RequestMapping("/")
//	public String home() {
//		
//	}
}
