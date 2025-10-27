package com.example.MyController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Model.User;
import com.example.Model.song;
import com.example.MyServices.MyServices;

@Controller
public class MyController {
	
	@Autowired
	MyServices s;
	
	@GetMapping("/")
	public String home(Model model) {
		List<song> songs = s.getAllSongs();
		model.addAttribute("songs", songs);
		return "User/home";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "User/login";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "User/register";
	}
	
	@GetMapping("/profile")
	public String profilePage(HttpSession session, Model model) {
		User u = (User) session.getAttribute("LoggedIn");
		if(u != null) {
			model.addAttribute("user", u);
			List<song> songs = s.getAllSongs();
			model.addAttribute("songs", songs);
			return "User/profile";
		}
		model.addAttribute("msg", "Login first to access whole Application...");
		return "User/login";
	}
	
	@GetMapping("/artist")
	public String artistsPage(Model model) {
		List<song> songs = s.getAllSongs();
		model.addAttribute("songs", songs);
		return "User/artist";
	}
	
	@GetMapping("/playlist")
	public String playlistPage(HttpSession session,Model model) {
		User u = (User) session.getAttribute("LoggedIn");
		if(u != null) {
			model.addAttribute("user", u);
			// user's playlist 
			List<song> songs = s.getAllSongs();
			model.addAttribute("songs", songs);
			return "User/playlist";
		}
		model.addAttribute("msg", "Login first to access whole Application...");
		return "User/login";
	}
}