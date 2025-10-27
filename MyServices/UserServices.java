package com.example.MyServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.User;
import com.example.MyDao.UserDao;

@Service
public class UserServices {

	@Autowired
	UserDao d;
	
	public void addUser(User u) {
		d.save(u);
	}

	public User findByEmail(String email) {
		return d.findByEmail(email);
	}
}
