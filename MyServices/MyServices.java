package com.example.MyServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.song;
import com.example.MyDao.MyDao;

@Service
public class MyServices {
	
	@Autowired
	MyDao d;

	public List<song> getAllSongs() {
		return d.findAll();
	}
	
	
}
