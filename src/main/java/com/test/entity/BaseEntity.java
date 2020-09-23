package com.test.entity;

public class BaseEntity {
    private String entityType;

    public BaseEntity(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityType() {
        return entityType;
    }
}
