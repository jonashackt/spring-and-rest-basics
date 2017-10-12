package com.cc.spring.model;

import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class TaskList extends AbstractBaseEntity {

	private static final long serialVersionUID = -737437092344345590L;

    private String name;

    private User owner;

    private List<Task> tasks;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, owner);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TaskList) {
            TaskList taskList = (TaskList)obj;
            return new EqualsBuilder()
                    .append(name, taskList.getName())
                    .append(owner, taskList.getOwner())
                    .isEquals();

        }
        return false;
    }
}
