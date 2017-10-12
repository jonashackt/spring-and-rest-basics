package com.cc.spring.repository;

import com.cc.spring.model.User;



public interface UserRepository {
	
	public User save(User task);

	User findOne(long userId);

	Iterable<User> findAll();

	void delete(User task);

	long count();
	
	boolean exists(long userId);
	
}
