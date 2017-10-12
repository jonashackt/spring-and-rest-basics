package com.cc.spring.repository;

import com.cc.spring.model.TaskList;




public interface TaskListRepository {
	
		
	public TaskList save(TaskList taskList);

	TaskList findOne(long taskListId);

	Iterable<TaskList> findAll();

	void delete(TaskList taskList);

	long count();
	
	boolean exists(long taskListId);

}
