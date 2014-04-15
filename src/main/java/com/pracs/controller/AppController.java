package com.pracs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pracs.service.UserService;
import com.pracs.util.ValidateUtil;

@Controller
public class AppController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/login.htm")
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("isAdmin");
		session.removeAttribute("uname");
		session.invalidate();
		return "redirect:login.htm";
	}
	
	@RequestMapping(value = "/validate.htm", method = RequestMethod.GET)
	public String validate1(){
		return "redirect:login.htm";
	}

	@RequestMapping(value = "/validate.htm", method = RequestMethod.POST)
	public String validate(
			@RequestParam(value = "username", required = true) String name,
			@RequestParam(value = "password", required = true) String password,
			Model model,
			HttpSession session) {
		System.out.println("name " + name);
		
		//System.out.println(userService.getUser(name));
		
		if (!ValidateUtil.isValid(name, password)) {
			session.setAttribute("message", "Username or Password is invalid.");
			return "redirect:login.htm";
		}
		
		if( ValidateUtil.isAdmin(name) ){
			session.setAttribute("isAdmin", true);
		}
		
		session.setAttribute("uname", name);
		
		return "redirect:home.htm";
	}
	
	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String home(){

		return "home";
	}


	
	
}
