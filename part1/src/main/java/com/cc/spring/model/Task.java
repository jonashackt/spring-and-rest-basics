package com.cc.spring.model;

import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Task extends AbstractBaseEntity{
	
	private static final long serialVersionUID = -4300223330074763788L;

    private TaskList taskList;
	
    private String title;
    
    private Date dueDate;
    
    private Date closed;

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskList, title, dueDate, closed);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Task) {
            Task task = (Task)obj;
            return new EqualsBuilder()
                    .append(taskList, task.getTaskList())
                    .append(title, task.getTitle())
                    .append(dueDate, task.getDueDate())
                    .append(closed, task.getClosed())
                    .isEquals();
        }
        return false;
    }
}
