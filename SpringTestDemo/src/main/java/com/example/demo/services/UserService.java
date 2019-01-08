package com.example.demo.services;

import com.example.demo.models.User;

public interface UserService {
	public User findUserByName(String email);
	public void saveUser(User user);
	public Iterable<User> findAll();
}
