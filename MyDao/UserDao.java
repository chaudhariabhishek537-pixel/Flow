package com.example.MyDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);

}