package com.cc.spring.service;

import com.cc.spring.model.User;
import com.cc.spring.repository.TaskRepository;
import com.cc.spring.repository.UserRepository;

public interface UserTaskService {
	
	public void setTaskRepository(TaskRepository taskRepository);

	public void setUserRepository(UserRepository userRepository);
	
	User findUserByTaskTitle(String taskDescription);
}
