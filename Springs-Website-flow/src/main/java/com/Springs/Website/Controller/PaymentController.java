package com.Springs.Website.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Springs.Website.Model.UsersInfo;
import com.Springs.Website.Repository.RepoDAO;

@Controller
@RequestMapping("/Payment")
public class PaymentController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String paymentGetmtd(@ModelAttribute UsersInfo info, ModelMap model){
		
		return "Payment";
	}
	
	@RequestMapping(value = "/MakePayment",method = RequestMethod.GET)
	public String paymentGetmtd1(@ModelAttribute UsersInfo info, ModelMap model){
		
		return "MakePayment";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String paymentPostmtd(@ModelAttribute @Valid UsersInfo inf,BindingResult result,HttpServletRequest req, ModelMap model){
		
		String amount = req.getParameter("Pay");
		System.out.println("Form payment controller and post method "+amount);
		
		RepoDAO rp = new RepoDAO();
		String bal = rp.balance().trim().substring(1);
		System.out.println("Form payment controller and post method bal:"+bal);
		
		return "Payment";
	}

}
