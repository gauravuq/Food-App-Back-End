package com.gaurav.food.app.order.service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "OrderItemInstance")
public class OrderItemInstance {

    @Id
    @GeneratedValue // Generating id through jpa
    private Long id;
    @Column(name = "Order_Item_Name", nullable = false)
    private String orderItemName;
    @ManyToOne()
    @JoinColumn(name="Order_Instance_Id")
    private OrderInstance orderInstanceId;
    @Column(name = "Order_Item_Type", nullable = false)
    private String orderItemType;
    @Column(name = "Order_Item_Quantity", nullable = false)
    private Integer orderItemQuantity;
    @Column(name = "Created_By", nullable = false)
    private String createdBy;
    @Column(name = "Updated_By", nullable = false)
    private String updatedBy;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    public Long getId() {
        return id;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    @JsonIgnore
    public OrderInstance getOrderInstanceId() {
        return orderInstanceId;
    }

    public void setOrderInstanceId(OrderInstance orderInstanceId) {
        this.orderInstanceId = orderInstanceId;
    }

    public String getOrderItemType() {
        return orderItemType;
    }

    public void setOrderItemType(String orderItemType) {
        this.orderItemType = orderItemType;
    }

    public Integer getOrderItemQuantity() {
        return orderItemQuantity;
    }

    public void setOrderItemQuantity(Integer orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public OrderItemInstance(String orderItemName, String orderItemType, Integer orderItemQuantity, String createdBy, String updatedBy) {
        this.orderItemName = orderItemName;
        this.orderItemType = orderItemType;
        this.orderItemQuantity = orderItemQuantity;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public OrderItemInstance() {
    }

    @Override
    public String toString() {
        return "OrderItemInstance{" +
                "id=" + id +
                ", orderItemName='" + orderItemName + '\'' +
                ", orderItemType='" + orderItemType + '\'' +
                ", orderItemQuantity=" + orderItemQuantity +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
