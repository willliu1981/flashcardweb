package com.ilan.control.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilan.model.user.User;

@Service
public class Book extends AbstractBook {
	@Autowired
	User user;

	String name;

	public Book() {
		System.out.println("book is created");
		this.name="C++";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
