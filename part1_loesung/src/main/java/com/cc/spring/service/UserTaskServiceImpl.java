package com.cc.spring.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.cc.spring.model.Task;
import com.cc.spring.model.User;
import com.cc.spring.repository.TaskRepository;
import com.cc.spring.repository.UserRepository;

public class UserTaskServiceImpl implements UserTaskService {

	TaskRepository taskRepository;

	UserRepository userRepository;

	public void setTaskRepository(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findUserByTaskTitle(String taskTitle) {
		
		Task task = taskRepository.findByTaskTitle(taskTitle);
		
		return task.getTaskList().getOwner();
	}
	
	@PostConstruct
	public void startup() {
		System.out.println(this.getClass() + ": PostConstruct"+taskRepository+" "+userRepository);
	}
	
	@PreDestroy
	public void tearDown() {
		System.out.println(this.getClass() + ": PreDestroy");
	}
}
