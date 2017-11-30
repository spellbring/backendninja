package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.model.UserCredential;

@Controller
public class LoginController {
	
	
	private static final String REDIRECT_VIEW = "redirect:/login";
	private static final String REDIRECT_VIEW_ERROR = "redirect:/login?error";
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	
	
	@GetMapping("/login")
	public ModelAndView showLoginForm(@RequestParam(name="error", required = false) String error
			, @RequestParam(required = false, name = "logout") String logout ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("logout", logout);
		modelAndView.addObject("error", error);
		
		return modelAndView;
	}
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck(@ModelAttribute(name = "userCredential") UserCredential userCredential) {
		
	
		return ViewConstant.REDIRECT_SHOW_CONTACTS;
		
		
		
	}
}
