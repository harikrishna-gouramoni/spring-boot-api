package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_INFO")
public class User {
	
	 public User() {
		 
	 }
	 public User(String username, String email, String city) {
		super();
		this.username = username;
		this.email = email;
		this.city = city;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 public long id;
	 
	 @Column(name="username")
	 public String username;
	 
	 @Column(name="email")
	 public String email;
	 
	 @Column(name="city")
	 public String city;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserEntity [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", email=");
		builder.append(email);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}

}
