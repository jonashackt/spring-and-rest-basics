package com.cc.spring.model;

import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


public class User extends AbstractBaseEntity{

	private static final long serialVersionUID = -1326910855503336257L;

    private String name;

    private List<TaskList> taskLists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(List<TaskList> taskLists) {
        this.taskLists = taskLists;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User) {
            User user = (User)obj;
            return new EqualsBuilder()
                    .append(name, user.getName())
                    .isEquals();

        }
        return false;
    }
}
