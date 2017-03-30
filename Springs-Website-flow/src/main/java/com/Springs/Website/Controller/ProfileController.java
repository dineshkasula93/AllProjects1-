package com.Springs.Website.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Springs.Website.Model.UsersInfo;


@Controller
@RequestMapping("/Profile")
public class ProfileController {

	@RequestMapping(method = RequestMethod.GET)
	public String profilePage(@ModelAttribute UsersInfo info, ModelMap model) {
		// UsersInfo ui = new UsersInfo();
		// model.addAttribute("user", ui);
		return "Profile";
	}
}
