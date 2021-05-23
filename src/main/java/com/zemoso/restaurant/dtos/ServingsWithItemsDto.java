package com.zemoso.restaurant.dtos;

import java.util.List;

public class ServingsWithItemsDto {
    private Long id;

    private String tableName;

    private Integer totalItems;

    private Double totalAmount;

    private String tableNo;

    private List<ServingItemDto> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ServingItemDto> getItems() {
        return items;
    }

    public void setItems(List<ServingItemDto> items) {
        this.items = items;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }
}
