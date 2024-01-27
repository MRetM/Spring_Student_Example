package com.ai.jwd48.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ai.jwd48.dto.LoginDTO;
import com.ai.jwd48.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping({ "/", "/login" })
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginDTO") LoginDTO loginDTO, ModelMap model, HttpSession session) {

		String username = loginDTO.getUsername();
		String password = loginDTO.getPassword();

		if (userService.checkUserNameAndPassword(username, password)) {
			session.setAttribute("loginUserName", username);
			return "welcome";
		} else {
			model.addAttribute("message", "Invalid UserName and Password!!");
			return "login";
		}
	}
	
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("isLoggedIn");
        session.removeAttribute("currentUser");
        session.removeAttribute("isUser");
        session.removeAttribute("isAdmin");
        return "redirect:/";
    }


}
