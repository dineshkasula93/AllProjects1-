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
@RequestMapping("/Register")
public class RegisterController {
	@RequestMapping(method = RequestMethod.GET)
	public String resiterMethod(@ModelAttribute UsersInfo info, ModelMap model) {
		// UsersInfo ui = new UsersInfo();
		// model.addAttribute("user", ui);
		return "Register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registartionDetails(@Valid @ModelAttribute UsersInfo info, BindingResult result,
			HttpServletRequest req, Model model) {

		String fName = req.getParameter("Firstname");
		String lName = req.getParameter("Lastname");
		String mail = req.getParameter("Email");
		String uName = req.getParameter("UserName");
		String Pass = req.getParameter("Password");
		Long phone = Long.parseLong(req.getParameter("PhoneNumber"));
		String mName = req.getParameter("MaidenName");
		System.out.println("Login controller \t" + fName + "\t" + lName + "\t" + mail + "\t" + uName + "\t" + Pass
				+ "\t" + phone + "\t" + mName);

		UsersInfo usf = UsersInfo.getinstance();
		usf.setFirstname(fName);
		usf.setLastname(lName);
		usf.setEmail(mail);
		usf.setUsername(uName);
		usf.setPassword(Pass);
		usf.setPhonenumber(phone);
		usf.setMaidenname(mName);
		ArrayList<UsersInfo> userInf = new ArrayList<UsersInfo>();
		userInf.add(usf);
		RepoDAO rd = new RepoDAO();
		if ((fName.length() > 3) && (lName.length() > 3) && (mail.length() > 13) && (uName.length() > 7)
				&& (Pass.length() > 5) && (phone.SIZE > 10) && (mName.length() > 4)) {
			rd.insertUserInfo(userInf);
			System.out.println("UsersInfo uname from Register controller:" + usf.Uname);
//			boolean valueOfDetails = rd.getDetails();
//			System.out.println("Form the Login controller:  " + valueOfDetails);
			return "Login";
		} else {
			return "Failure";
		}
	}

}
