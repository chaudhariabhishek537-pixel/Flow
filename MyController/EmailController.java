package com.example.MyController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Model.User;
import com.example.MyServices.EmailServices;
import com.example.MyServices.MyServices;
import com.example.MyServices.UserServices;


@Controller
public class EmailController {
	
	@Autowired
	EmailServices s;
	
	@Autowired
	MyServices ss;
	
	@Autowired
	UserServices us;
	
	int otpS ;
	String emailT;
	String passT;
	String nameT;
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		nameT = name;
		emailT = email;
		passT = password;
		System.out.println();
		otpS =(int) (Math.random()*1000000);
		System.out.println(otpS);
		s.sendMail(email,otpS);
		return "User/otp";
	}
	
	@PostMapping("/verifyOtp")	
	public String verifyOtp(@RequestParam int otp, Model model) {
		if(otp != 0 && otpS == otp) {
			User u = new User();
			u.setName(nameT);
			u.setEmail(emailT);
			u.setPassword(passT);
			// add user to database
			us.addUser(u);
			return "redirect:/login";
		}else {
			System.out.println("Please enter correct OTP.");
			model.addAttribute("msg", "Please enter correct OTP.");
			return "User/otp";
		}
	}
}
