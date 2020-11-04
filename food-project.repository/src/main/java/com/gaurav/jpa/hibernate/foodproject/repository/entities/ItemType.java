package com.gaurav.jpa.hibernate.foodproject.repository.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ItemType")
public class ItemType {

    @Id
    @GeneratedValue // Generating id through jpa
    private Long id ;
    @Column(name = "Item_Name",nullable = false)
    private String itemName;
    @Column(nullable = false)
    private String ingredients;
    @Column(name = "Created_By",nullable = false)
    private String createdBy;
    @Column(name = "Updated_By",nullable = false)
    private String updatedBy;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    public ItemType() {
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
