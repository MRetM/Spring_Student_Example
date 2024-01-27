package com.ai.jwd48.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/welcome")
	public String welcome(ModelMap model) {
		model.addAttribute("message","Welcome from Spring MVC!!");
		return "welcome";
	}

	@RequestMapping("/home")
	public String index() {
		return "home";
	}

}
