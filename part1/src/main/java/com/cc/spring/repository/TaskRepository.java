package com.cc.spring.repository;

import com.cc.spring.model.Task;


public interface TaskRepository {
	
	public Task save(Task task);

	Task findOne(long taskId);

	Iterable<Task> findAll();

	void delete(Task task);

	long count();
	
	boolean exists(long taskId);
	
	Task findByTaskTitle(String taskTitle);
	
}
