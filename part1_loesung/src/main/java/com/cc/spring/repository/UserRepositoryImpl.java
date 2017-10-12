package com.cc.spring.repository;

import java.util.List;

import com.cc.spring.model.ModelFactory;
import com.cc.spring.model.User;
import com.google.common.collect.Lists;

public class UserRepositoryImpl implements UserRepository {

	private List<User> users = Lists.newArrayList();

	public UserRepositoryImpl() {
		users = ModelFactory.getUsers();
	}

	@Override
	public User save(User user) {

		if (!users.contains(user)) {
			users.add(user);
		}
		return user;
	}

	@Override
	public User findOne(long userId) {
		for (User user : users) {
			if (user.getId().equals(userId)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public Iterable<User> findAll() {
		return users;
	}

	@Override
	public void delete(User user) {
		users.remove(user);
	}

	@Override
	public long count() {
		return users.size();
	}

	@Override
	public boolean exists(long userId) {
		for (User user : users) {
			if (user.getId().equals(userId)) {
				return true;
			}
		}
		return false;
	}
}
