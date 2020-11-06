package com.gaurav.jpa.hibernate.foodproject.repository.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MenuInstance")

public class MenuInstance {

    @Id
    @GeneratedValue // Generating id through jpa
    private Long id ;

    @NotEmpty
    @NotNull
    @Column(name = "Menu_Name",nullable = false)
    private String menuName;
    @Column(name = "Created_By",nullable = false)
    private String createdBy;
    @Column(name = "Updated_By",nullable = false)
    private String updatedBy;
    //@OneToMany(mappedBy = "menuInstance",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "Menu_Instance_Id")
    private List<MenuItemInstance> menuItemInstances = new ArrayList<>();

    public List<MenuItemInstance> getMenuItemInstances() {
        return menuItemInstances;
    }

    public void addMenuItemInstance(MenuItemInstance menuItemInstance) {
        this.menuItemInstances.add(menuItemInstance);
    }

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    public Long getId() {
        return id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
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

    public MenuInstance(String menuName, String createdBy, String updatedBy) {
        this.id = id;
        this.menuName = menuName;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public MenuInstance() {
    }

    @Override
    public String toString() {
        return "MenuInstance{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
