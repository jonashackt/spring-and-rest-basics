package com.cc.spring.repository;

import java.util.List;

import com.cc.spring.model.ModelFactory;
import com.cc.spring.model.TaskList;
import com.google.common.collect.Lists;

public class TaskListRepositoryImpl implements TaskListRepository {

	private List<TaskList> taskLists = Lists.newArrayList();

	public TaskListRepositoryImpl() {
		taskLists = ModelFactory.getTaskLists();
	}

	@Override
	public TaskList save(TaskList taskList) {

		if (!taskLists.contains(taskList)) {
			taskLists.add(taskList);
		}
		return taskList;
	}

	@Override
	public TaskList findOne(long taskListId) {
		for (TaskList taskList : taskLists) {
			if (taskList.getId().equals(taskListId)) {
				return taskList;
			}
		}
		return null;
	}

	@Override
	public Iterable<TaskList> findAll() {
		return taskLists;
	}

	@Override
	public void delete(TaskList taskList) {
		taskLists.remove(taskList);
	}

	@Override
	public long count() {
		return taskLists.size();
	}

	@Override
	public boolean exists(long taskListId) {
		for (TaskList taskList : taskLists) {
			if (taskList.getId().equals(taskListId)) {
				return true;
			}
		}
		return false;
	}

}
