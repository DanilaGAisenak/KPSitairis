package com.company.moviemarking.service;

import com.company.moviemarking.entity.User;

import java.util.List;

public interface UserService {
	List<User> findAllUsers();

	User save(User user);

	void removeUser(int id);

	User findUserByUsername(String username);

	User findUserById(int id);
}
