package com.thymeleaf.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model)
	{
		// Putting data
		System.out.println("This is The About Page");
		model.addAttribute("name", "Jatnder Khatri");
		model.addAttribute("date", new Date());
		model.addAttribute("teacherName", "Raheem Sir");
		return "about";
	}
}
