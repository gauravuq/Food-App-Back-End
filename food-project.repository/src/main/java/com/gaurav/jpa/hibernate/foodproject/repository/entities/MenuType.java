package com.gaurav.jpa.hibernate.foodproject.repository.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="MenuType")
public class MenuType {
    @Id
    @GeneratedValue // Generating id through jpa
    private Long id ;
    @Column(name = "Menu_Name",nullable = false)
    private String menuName;
    @Column(name = "Created_By",nullable = false)
    private String createdBy;
    @Column(name = "Updated_By",nullable = false)
    private String updatedBy;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    public MenuType() {

    }

    @Override
    public String toString() {
        return "MenuType{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
