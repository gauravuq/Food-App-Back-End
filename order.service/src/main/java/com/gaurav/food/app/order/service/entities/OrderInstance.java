package com.gaurav.food.app.order.service.entities;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OrderInstance")
public class OrderInstance {

    @Id
    @GeneratedValue // Generating id through jpa
    private Long id;
    @NotEmpty
    @NotNull
    @Column(name = "Order_Customer_Name", nullable = false)
    private String orderCustomerName;
    @NotEmpty
    @NotNull
    @Column(name = "Order_Customer_Email", nullable = false)
    private String orderCustomerEmail;
    @Column(name = "Order_Menu_Type", nullable = false)
    private String orderMenuType;
    @Column(name = "Order_For_Date", nullable = false)
    private LocalDate orderForDate;
    @Column(name = "Order_Customer_Room", nullable = false)
    private String orderCustomerRoom;
    @OneToMany(mappedBy = "orderInstanceId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderItemInstance> orderItemInstances = new ArrayList<>();
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


    public String getOrderCustomerName() {
        return orderCustomerName;
    }

    public void setOrderCustomerName(String orderCustomerName) {
        this.orderCustomerName = orderCustomerName;
    }

    public String getOrderCustomerEmail() {
        return orderCustomerEmail;
    }

    public void setOrderCustomerEmail(String orderCustomerEmail) {
        this.orderCustomerEmail = orderCustomerEmail;
    }

    public String getOrderMenuType() {
        return orderMenuType;
    }

    public void setOrderMenuType(String orderMenuType) {
        this.orderMenuType = orderMenuType;
    }

    public LocalDate getOrderForDate() {
        return orderForDate;
    }

    public void setOrderForDate(LocalDate orderForDate) {
        this.orderForDate = orderForDate;
    }

    public String getOrderCustomerRoom() {
        return orderCustomerRoom;
    }

    public void setOrderCustomerRoom(String orderCustomerRoom) {
        this.orderCustomerRoom = orderCustomerRoom;
    }

    public List<OrderItemInstance> getOrderItemInstances() {
        return orderItemInstances;
    }

    public void addOrderItemInstance(OrderItemInstance orderItemInstance) {
        this.orderItemInstances.add(orderItemInstance);
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

    public OrderInstance(@NotEmpty @NotNull String orderCustomerName, @NotEmpty @NotNull String orderCustomerEmail, String orderMenuType, LocalDate orderForDate, String orderCustomerRoom, List<OrderItemInstance> orderItemInstances, String createdBy, String updatedBy) {
        this.orderCustomerName = orderCustomerName;
        this.orderCustomerEmail = orderCustomerEmail;
        this.orderMenuType = orderMenuType;
        this.orderForDate = orderForDate;
        this.orderCustomerRoom = orderCustomerRoom;
        this.orderItemInstances = orderItemInstances;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public OrderInstance() {
    }

    @Override
    public String toString() {
        return "OrderInstance{" +
                "id=" + id +
                ", orderCustomerName='" + orderCustomerName + '\'' +
                ", orderCustomerEmail='" + orderCustomerEmail + '\'' +
                ", orderMenuType='" + orderMenuType + '\'' +
                ", orderForDate=" + orderForDate +
                ", orderCustomerRoom='" + orderCustomerRoom + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
