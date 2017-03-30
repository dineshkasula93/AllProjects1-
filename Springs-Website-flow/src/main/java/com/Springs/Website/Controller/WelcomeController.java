package com.Springs.Website.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String welcomePage(){
		return "Login";
	}
}
