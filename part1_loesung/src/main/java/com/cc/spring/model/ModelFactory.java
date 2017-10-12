package com.cc.spring.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class ModelFactory {
	
	private static List<User> users = Lists.newArrayList();
	
	private static List<Task> tasks = Lists.newArrayList();
	
	private static List<TaskList> taskLists = Lists.newArrayList();
	
	private static boolean modelCreated = false;
	
	private static void createModel() {
		
		User lahm = new User();
		lahm.setId(1L);
		lahm.setName("Lahm");
		lahm.setVersion(1);
		users.add(lahm);

		User mueller = new User();
		mueller.setId(2L);
		mueller.setName("Mueller");
		mueller.setVersion(1);
		users.add(mueller);
		
		User neuer = new User();
		neuer.setId(3L);
		neuer.setName("Neuer");
		neuer.setVersion(1);
		users.add(neuer);
		
		Task toreSchiessen = new Task();
		toreSchiessen.setId(1L);
		toreSchiessen.setTitle("Tore schiessen");
		toreSchiessen.setDueDate(new Date());
		tasks.add(toreSchiessen);
		
		Task toreVerhindern = new Task();
		toreVerhindern.setId(2L);
		toreVerhindern.setTitle("Tore verhindern");
		toreVerhindern.setDueDate(new Date());
		tasks.add(toreVerhindern);
		
		TaskList lahmsToDoList = new TaskList();
		lahmsToDoList.setId(1L);
		lahmsToDoList.setName("Lahms ToDo List");
		lahmsToDoList.setOwner(lahm);
		lahmsToDoList.setVersion(1);
		lahmsToDoList.setTasks(Arrays.asList(toreSchiessen, toreVerhindern));
		taskLists.add(lahmsToDoList);
		
		TaskList muellersToDoList = new TaskList();
		muellersToDoList.setId(2L);
		muellersToDoList.setName("Muellers ToDo List");
		muellersToDoList.setOwner(mueller);
		muellersToDoList.setVersion(1);
		muellersToDoList.setTasks(Arrays.asList(toreSchiessen));
		taskLists.add(muellersToDoList);

		TaskList neuersToDoList = new TaskList();
		neuersToDoList.setId(3L);
		neuersToDoList.setName("Neuers ToDo List");
		neuersToDoList.setOwner(neuer);
		neuersToDoList.setVersion(1);
		neuersToDoList.setTasks(Arrays.asList(toreVerhindern));
		taskLists.add(neuersToDoList);
		
		modelCreated = true;
	}
	
	
	public static List<TaskList> getTaskLists() {
		if (!modelCreated) {
			createModel();
		}
		return taskLists;
	}
	
	
	public static List<User> getUsers() {
		if (!modelCreated) {
			createModel();
		}
		return users;
	}
	
	public static List<Task> getTasks() {
		if (!modelCreated) {
			createModel();
		}
		return tasks;
	}
}
