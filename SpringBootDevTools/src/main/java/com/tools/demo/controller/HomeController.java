package com.tools.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/add")
	@ResponseBody
	public String sum()
	{
		Integer a = 10;
		Integer b = 30;
		Integer c = 30;
		Integer d = 40;
		return "Sum = " + (a+b+c+d);
	}
}
