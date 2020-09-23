package com.test;

public class OrderLevelRequest {
    private String entityName;
    private EntityEnum entityEnum;
    private Integer amount;
    private OrderDetails orderDetails;


    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public EntityEnum getEntityEnum() {
        return entityEnum;
    }

    public void setEntityEnum(EntityEnum entityEnum) {
        this.entityEnum = entityEnum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
