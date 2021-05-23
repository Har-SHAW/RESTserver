package com.zemoso.restaurant.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Serving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tableName;

    private Integer totalItems;

    private Double totalPrice;

    private String tableNo;

    private String waiterId;

    @OneToMany(mappedBy = "serving", cascade = CascadeType.ALL)
    private List<ServingItem> servingItems;

    public void addServingItem(ServingItem servingItem){
        if (this.servingItems == null){
            this.servingItems = new ArrayList<>();
        }
        this.servingItems.add(servingItem);
    }

    public Long getId() {
        return id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ServingItem> getServingItems() {
        return servingItems;
    }

    public void setServingItems(List<ServingItem> servingItems) {
        this.servingItems = servingItems;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public String getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }
}
