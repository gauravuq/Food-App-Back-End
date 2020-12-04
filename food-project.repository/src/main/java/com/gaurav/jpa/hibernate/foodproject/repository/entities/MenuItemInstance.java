package com.gaurav.jpa.hibernate.foodproject.repository.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "MenuItemInstance")
public class MenuItemInstance {

    @Id
    @GeneratedValue // Generating id through jpa
    private Long id;
    @Column(name = "Item_Name", nullable = false)
    private String itemName;
    @Column(name = "Item_Type", nullable = false)
    private String itemType;
    @Column(nullable = false)
    private String ingredients;
    @ManyToOne()
    @JoinColumn(name = "Menu_Instance_Id")
    private MenuInstance menuInstance;
    @Column(name="Item_Max_Limit",nullable = false)
    private Integer itemMaxLimit;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @JsonIgnore
    public MenuInstance getMenuInstance() {
        return menuInstance;
    }

    public void setMenuInstance(MenuInstance menuInstance) {
        this.menuInstance = menuInstance;
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

    public Integer getItemMaxLimit() { return itemMaxLimit; }

    public void setItemMaxLimit(Integer itemMaxLimit) { this.itemMaxLimit = itemMaxLimit; }

    public String getItemType() { return itemType; }

    public void setItemType(String itemType) { this.itemType = itemType; }

    public MenuItemInstance(String itemName,String itemType ,String ingredients, Integer itemMaxLimit, String createdBy, String updatedBy) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.ingredients = ingredients;
        this.itemMaxLimit = itemMaxLimit;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public MenuItemInstance() {
    }


    @Override
    public String toString() {
        return "MenuItemInstance{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", itemMaxLimit='" + itemMaxLimit + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
