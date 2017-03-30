package com.Springs.Website.Controller;

import javax.servlet.http.HttpServlet;
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
@RequestMapping("/Forgot")
public class ForgotPasswordController {

	public static String Username;
	@RequestMapping(method = RequestMethod.GET)
	public String forgotmethod(@ModelAttribute UsersInfo info, ModelMap model) {
		return "ForgotPassword";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String forgotPasssword(@Valid @ModelAttribute UsersInfo info, BindingResult result, HttpServletRequest req,
			Model model) {
		Username = req.getParameter("UserName");
		String eMail = req.getParameter("Email");
		String MName = req.getParameter("MaidenName");

		System.out.println("***************Form forgot pass controller***************");
		System.out.println(Username + " \t" + eMail + " \t " + MName);

		UsersInfo inf = UsersInfo.getinstance();
		inf.setUsername(Username);
		inf.setEmail(eMail);
		inf.setMaidenname(MName);
		RepoDAO rd = new RepoDAO();
		boolean val = rd.forgetPasswordMtd();
		if (val == true) {
			return "ResetPassword";
		} else {
			return "Failure";
		}
	}

	@RequestMapping(value = "/ResetPass", method = RequestMethod.POST)
	public String resetPassword(@Valid @ModelAttribute UsersInfo info, BindingResult result, HttpServletRequest req,
			Model model) {
		String pass = req.getParameter("Password");
		String repass = req.getParameter("Re-Password");
		System.out.println(pass+"---------Hey pass and repass-----------"+repass);
		RepoDAO rd = new RepoDAO();
		if (pass.equals(repass)) {
			UsersInfo inf1 = UsersInfo.getinstance();
			inf1.setUsername(Username);
			inf1.setPassword(repass);
			rd.resetPass();
		String newpass = rd.resetPass();
		System.out.println("-------------------New Password----------------"+newpass);
			return "PassChanged";
		}
		return "Failure";
	}

}
