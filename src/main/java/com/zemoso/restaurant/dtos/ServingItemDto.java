package com.zemoso.restaurant.dtos;

public class ServingItemDto {
    private Long servingItemsId;

    private ItemDto item;

    private int servings;

    public Long getServingItemsId() {
        return servingItemsId;
    }

    public void setServingItemsId(Long servingItemsId) {
        this.servingItemsId = servingItemsId;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }
}
