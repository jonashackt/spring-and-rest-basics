package com.cc.spring.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractBaseEntity implements Serializable {

    private long id;

    private Integer version;

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
