package com.example.MyServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServices {
	
	@Autowired
	private JavaMailSender mail;
	
	public void sendMail(String email,int otpS) {
		SimpleMailMessage msg = new SimpleMailMessage();
//		String admin = "chaudhariabhishek8292@gmail.com";
		String user = email;
		String subject = "Email verification....";
		String body = "Your one time (OTP) is "+ otpS +". \n Please enter otp in time, OTP will expired in 10mins.";
//		msg.setFrom(admin); // send from (Admin)
		msg.setTo(user); // send to user (user)
		msg.setSubject(subject);
		msg.setText(body);
		
		mail.send(msg);
	}
}