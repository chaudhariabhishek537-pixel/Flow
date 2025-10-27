package com.example.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String email;
	private String password;
	
	@OneToMany
	private List<song> sList;

	@OneToMany
	private List<song> favourite;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<song> getsList() {
		return sList;
	}

	public void setsList(List<song> sList) {
		this.sList = sList;
	}

	public List<song> getFavourite() {
		return favourite;
	}

	public void setFavourite(List<song> favourite) {
		this.favourite = favourite;
	}

	public User(int id, String name, String email, String password, List<song> sList, List<song> favourite) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.sList = sList;
		this.favourite = favourite;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", sList=" + sList
				+ ", favourite=" + favourite + "]";
	}
}
