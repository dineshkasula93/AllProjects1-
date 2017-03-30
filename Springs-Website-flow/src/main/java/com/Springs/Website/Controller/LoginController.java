package com.Springs.Website.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.Springs.Website.Model.UsersInfo;
import com.Springs.Website.Repository.RepoDAO;

@Controller
@RequestMapping("/Login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String passwordCheck(@ModelAttribute UsersInfo info, ModelMap model) {
		// UsersInfo ui = new UsersInfo();
		// model.addAttribute("user", ui);
		return "Welcome";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String userDetails(@Valid @ModelAttribute UsersInfo info, BindingResult result, HttpServletRequest req,
			Model model) {

		String uName = req.getParameter("UserName");
		String Pass = req.getParameter("Password");
		System.out.println("Login controller \t" + uName + "\t" + Pass);

		UsersInfo usf = UsersInfo.getinstance();
		usf.setUsername(uName);
		usf.setPassword(Pass);

		ArrayList<UsersInfo> userInf = new ArrayList<UsersInfo>();
		userInf.add(usf);
		RepoDAO rd = new RepoDAO();
		rd.getDetails();
		System.out.println("UsersInfo uname from Login controller:" + usf.Uname);
		String username = rd.UserName;
		String password = rd.Password;
		System.out.println("Form the Login controller:  " + username + "    " + password);
		if (username.equals(uName) && password.equals(Pass)) {
			return "Welcome";
		} else {
			return "Failure";
		}
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String pageDirect(@Valid @ModelAttribute UsersInfo info, Model model) {

		return "Welcome";

	}

}
