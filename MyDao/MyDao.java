package com.example.MyDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.song;

@Repository
public interface MyDao extends JpaRepository<song, Integer> {
	
}
