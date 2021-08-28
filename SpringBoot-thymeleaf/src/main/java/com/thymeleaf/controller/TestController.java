package com.thymeleaf.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/about")
	public String about(Model model) {
		// Putting data
		System.out.println("This is The About Page");
		model.addAttribute("name", "Jatnder Khatri");
		model.addAttribute("date", new Date());
		model.addAttribute("teacherName", "Raheem Sir");
		return "about";
	}

	@GetMapping("/about-iteration")

	public String getIteration(Model model) {
		List<String> list = List.of("jatender", "khatri", "kumar");
		model.addAttribute("name", list);
		return "about-iteration";
	}

	// Handler for Conditional Statement
	@GetMapping("/condition")
	public String conditional(Model m) {
		// Elvis Operator
		System.out.println("Handle the Conditional Statement");
		m.addAttribute("isActive", true);
		// IF and Else operator
		m.addAttribute("gender", "male");

		// Switch Statement

		List<Integer> list = List.of(1);
		m.addAttribute("myList", list);
		return "condition";
	}

	@GetMapping("/service")
	public String service(Model m) {
		m.addAttribute("title", "This is the My Title");
		m.addAttribute("subTitle", LocalDateTime.now().toString());
		return "service";
	}
}
