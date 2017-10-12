package com.cc.spring.repository;

import java.util.List;

import com.cc.spring.model.ModelFactory;
import com.cc.spring.model.Task;
import com.google.common.collect.Lists;

public class TaskRepositoryImpl implements TaskRepository {

	
	private List<Task> tasks = Lists.newArrayList();

	public TaskRepositoryImpl() {
		tasks = ModelFactory.getTasks();
	}

	@Override
	public Task save(Task task) {

		if (!tasks.contains(task)) {
			tasks.add(task);
		}
		return task;
	}

	@Override
	public Task findOne(long taskId) {
		for (Task task : tasks) {
			if (task.getId().equals(taskId)) {
				return task;
			}
		}
		return null;
	}

	@Override
	public Iterable<Task> findAll() {
		return tasks;
	}

	@Override
	public void delete(Task task) {
		tasks.remove(task);
	}

	@Override
	public long count() {
		return tasks.size();
	}

	@Override
	public boolean exists(long taskId) {
		for (Task task : tasks) {
			if (task.getId().equals(taskId)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Task findByTaskTitle(String taskTitle) {
		for (Task task : tasks) {
			if (task.getTitle().equals(taskTitle)) {
				return task;
			}
		}
		return null;
	}
}
