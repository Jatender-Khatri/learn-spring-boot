package com.form.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.form.entity.Login;

@Controller
public class MyController {
	@GetMapping("/form")
	public String openForm(Model model)
	{
		System.out.println("This is the Form Opening Proccess");
		model.addAttribute("loginData", new Login());
		return "form";
	}
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") Login loginData, BindingResult result)
	{
		if (result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		System.out.println(loginData);
		return "success";
	}
}
