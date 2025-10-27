package com.example.MyController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Model.User;
import com.example.MyServices.UserServices;

@Controller
public class UserController {

	@Autowired
	UserServices s;
	
	@PostMapping("/loginverify")
	public String loginverify(HttpSession session, @RequestParam String email, @RequestParam String password, Model model) {
		User u = s.findByEmail(email);
		System.out.println(u);
		if(u != null) {
			if(password != null && password.equals(u.getPassword())) {
				String name = u.getName();
				model.addAttribute("msg", "Welcome "+name);
				session.setAttribute("LoggedIn", u);
				return "User/home";
			}else {
				model.addAttribute("msg", "Wrong password entered....");
				return "User/login";
			}
		}
		model.addAttribute("msg", "Account with these Email not exist....");
		return "User/login";
	}
}